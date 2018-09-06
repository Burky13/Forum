package forum.services.ratingService;

import forum.Entity.Rating;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class RatingService {

    @PersistenceContext
    private EntityManager entityManager;

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

    public double getAvgRating(int commentID){
        return  entityManager.createQuery("Select avg(value) from Rating r where r.commentId = :commentid", Double.class)
                .setParameter("commentid", commentID).getSingleResult();
    }

}
