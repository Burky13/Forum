package forum.services.rating;

import forum.entity.Comment;
import forum.entity.Rating;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RatingServiceJpa implements RatingService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void changeRating(Rating rating) {
        Rating r = null;
        Comment c = null;
        try {
            r = entityManager.createQuery("Select r from Rating r where r.userName = :username and r.commentId = :commentid", Rating.class)
                    .setParameter("username", rating.getUserName()).setParameter("commentid", rating.getCommentId())
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        if (r != null) {
            r.setValue(rating.getValue());
        } else {
            entityManager.persist(rating);
        }
        try {
            c = entityManager.createQuery("Select c from Comment c where r.id = :commentid and r.userName = :username", Comment.class)
                   .setParameter("commentid", rating.getCommentId()).setParameter("username", rating.getPoster()).getSingleResult();
        } catch (NoResultException e) { }
        c.setRating(getAvgRating(c.getTopicId(),"comment"));
        entityManager.merge(c);
    }

    @Override
    public double getAvgRating(long commentID, String type){
        double likes = 0;
        double dislikes = 0;

        try {
            likes = entityManager.createQuery("Select count(value) from Rating r where r.commentId = :commentid and r.value = 1 and r.type = :type", Double.class)
                    .setParameter("commentid", commentID).setParameter("type", type).getSingleResult();
        }catch (NoResultException e){}
        try {
            dislikes = entityManager.createQuery("Select count(value) from Rating r where r.commentId = :commentid and r.value = -1 and r.type = :type", Double.class)
                    .setParameter("commentid", commentID).setParameter("type", type).getSingleResult();
        }catch (NoResultException e){}

        if(likes == 0 && dislikes == 0){
            return 0.5;
        }else{
            return likes / (likes + dislikes);
        }

    }

    @Override
    public double getUserRating(String userName) {
        try {
            return entityManager.createQuery("Select avg(rating) from Comment c where c.userName = :userName", Double.class).setParameter("userName",userName).getSingleResult();
        }catch (NoResultException e){
            return 0.5;
        }
    }
}
