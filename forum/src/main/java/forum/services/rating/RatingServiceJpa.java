package forum.services.rating;

import forum.controllers.UserController;
import forum.entity.Comment;
import forum.entity.Rating;
import forum.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RatingServiceJpa implements RatingService{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public double getAvgRating(Long id) {
        Comment comment = null;
        try{
            comment = entityManager.createQuery("Select c from Comment c where c.id = :id",Comment.class).setParameter("id",id).getSingleResult();
        }catch (NoResultException e){}
        Double value = entityManager.createQuery("Select avg(r.value) from Rating r where r.comment = :comment", Double.class).setParameter("comment", comment).getSingleResult();
        if(value != null){
            return value;
        }else {
            return 0.5;
        }
    }

    @Override
    public double getUserRating(User user) {
        List<Comment> comments;
        double value = 0;
        try {
            comments = entityManager.createQuery("Select c from Comment c where c.user = user").setParameter("user",user).getResultList();
        }catch (NoResultException e){
            return 0.5;
        }
        for(Comment comment: comments){
            value += getAvgRating(comment.getId());
        }
        return value/comments.size();
    }

    @Override
    public void changeRating(Long id, Rating r) {
        Rating rr = null;
        Comment c = null;
        try {
            c = entityManager.createQuery("Select c from Comment c where c.id = :id", Comment.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e){System.out.println("nedobre");}
        if(c != null){
            r.setComment(c);
        }
        try {
            rr = entityManager.createQuery("Select r from Rating r where r.comment = :comment and r.user = :user",Rating.class)
                    .setParameter("comment", c).setParameter("user", r.getUser()).getSingleResult();
        }catch (NoResultException e){}
        if(rr != null){
            if(rr.getValue() == r.getValue()) {
                entityManager.remove(rr);
            }else{
                entityManager.remove(rr);
                entityManager.persist(r);
            }
        }else{
            entityManager.persist(r);
        }
    }

    @Override
    public int userVote(Long id ,User user){
        Integer value = null;
        Comment c = null;
        try {
            c = entityManager.createQuery("Select c from Comment c where c.id = :id", Comment.class).setParameter("id", id).getSingleResult();
        }catch (NoResultException e){}
        try {
            value = entityManager.createQuery("Select r.value from Rating r where r.comment = :comment and r.user = :user",Integer.class).setParameter("comment",c).setParameter("user",user).getSingleResult();
        }catch (NoResultException e){}
        if(value != null){
            return value;
        }else{
            return  2;
        }
    }
}
