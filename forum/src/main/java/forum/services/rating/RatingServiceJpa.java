package forum.services.rating;

import forum.entity.Comment;
import forum.entity.Rating;
import forum.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class RatingServiceJpa implements RatingService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void changeRating(Rating rating) {
        Rating r = null;
        try {
            r = entityManager.createQuery("Select r from Rating r where r.comment = :comment and r.user = :user",Rating.class)
                    .setParameter("comment", rating.getComment()).setParameter("user", rating.getUser()).getSingleResult();
        }catch (NoResultException e){
            entityManager.persist(rating);
        }
        if(r != null){
            r.setRating(rating.getRating());
        }
    }

    @Override
    public double getAvgRating(Comment comment){
        try {
            return entityManager.createQuery("Select avg(value) from Rating r where r.comment = :comment",Double.class)
                    .setParameter("comment", comment).getSingleResult();
        }catch (NoResultException e){
            return 0.5;
        }
    }

    @Override
    public double getUserRating(User user) {
        List<Comment> comments;
        double value = 0;
        try {
            comments = entityManager.createQuery("Select c from Comment c where r.user = user").setParameter("user",user).getResultList();
        }catch (NoResultException e){
            return 0.5;
        }
        for(Comment comment: comments){
            value += getAvgRating(comment);
        }
        return value/comments.size();
    }
}
