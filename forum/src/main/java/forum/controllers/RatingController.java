package forum.controllers;

import forum.entity.Comment;
import forum.entity.Rating;
import forum.services.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private UserController userController;

    EntityManager entityManager;

    public static void main(String[] args){

    }

    @RequestMapping("/rate")
    public String changeRating(@RequestParam ("id")double commentID,
                               @RequestParam ("rate")int rate){

        if(userController.isLogged()){
            Rating rating = new Rating(entityManager.createQuery("Select c from Comment c where c.id = :id", Comment.class).setParameter("id",commentID).getSingleResult(),
                                        userController.getLoggedUser(),
                                        rate);
            ratingService.changeRating(rating);
        }else{
            System.out.println("Ta nesi lognuty more !!");
        }
        return "somewhere :)";
    }

    public double getCommentRating(double id) {
        Comment c = null;
        try{
            c = entityManager.createQuery("Selecet c from Comment c where c.id = :id", Comment.class).setParameter("id",id).getSingleResult();
        }catch(NoResultException e){

        }
        if(c != null) {
            return ratingService.getAvgRating(c);
        }else{
            return 0.0;
        }
    }
}
