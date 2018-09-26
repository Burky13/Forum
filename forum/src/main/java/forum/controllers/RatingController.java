package forum.controllers;

import forum.entity.Comment;
import forum.entity.Rating;
import forum.services.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    Model model;

    public static void main(String[] args){

    }


    @RequestMapping("changerating")
    public String changeRating(Long id, Integer value) {
        if(userController.isLogged()) {
            Rating r = new Rating();
            r.setUser(userController.getLoggedUser());
            r.setValue(value);
            ratingService.changeRating(id, r);
        }
        System.out.println(id);
        return "redirect:/theme";
    }

    public int userVote(Long id){
        Long idd = new Long(id);
        return ratingService.userVote(idd,userController.getLoggedUser());
    }
}
