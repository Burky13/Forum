package forum.controllers;

import forum.entity.Rating;
import forum.services.rating.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class RatingController {

    @Autowired
    private RatingService ratingService;
    @Autowired
    private UserController userController;

    public static void main(String[] args){

    }

    @RequestMapping("/ratecomment")
    public String changeCommentRating(Rating rating){
        if(rating.getValue() != 0 && userController.isLogged()){
            rating.setUserName(userController.getLoggedUserName());
            rating.setType("comment");
            ratingService.changeRating(rating);
        }
        return "somewhere :)";
    }

    @RequestMapping("/rateuser")//blud, pridat poster string do entity
    public String changeUserRating(Rating rating){
        if(rating.getValue() != 0 && userController.isLogged()){
            rating.setUserName(userController.getLoggedUserName());
            rating.setType("user");
            ratingService.changeRating(rating);
        }
        return "somewhere :)";
    }

    @RequestMapping("/ratetheme")
    public String changeThemeRating(Rating rating){
        if(rating.getValue() != 0 && userController.isLogged()){
            rating.setUserName(userController.getLoggedUserName());
            rating.setType("theme");
            ratingService.changeRating(rating);
        }
        return "somewhere :)";
    }
}
