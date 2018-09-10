package forum.services.rating;

import forum.entity.Rating;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class RatingServiceJpa implements RatingService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void changeRating(Rating rating){
        Rating r = null;
        try {
            r = entityManager.createQuery("Select r from Rating r where r.userName = :username and r.commentId = :commentid", Rating.class)
            .setParameter("username", rating.getUserName()).setParameter("commentid", rating.getCommentId())
            .getSingleResult();
        } catch (NoResultException e){ }
        if (r != null){
            r.setValue(rating.getValue());
        }else{
            entityManager.persist(rating);
        }
    }

    @Override
    public double getAvgRating(long commentID){
        double likes = 0;
        double dislikes = 0;

        try {
            likes = entityManager.createQuery("Select count(value) from Rating r where r.commentId = :commentid and r.value = 1", Double.class)
                    .setParameter("commentid", commentID).getSingleResult();
        }catch (NoResultException e){}
        try {
            dislikes = entityManager.createQuery("Select count(value) from Rating r where r.commentId = :commentid and r.value = -1", Double.class)
                    .setParameter("commentid", commentID).getSingleResult();
        }catch (NoResultException e){}

        if(likes == 0 && dislikes == 0){
            return 50;
        }else{
            return (likes + dislikes) / likes;
        }
    }
}
