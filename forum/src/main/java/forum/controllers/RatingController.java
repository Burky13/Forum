package forum.controllers;

import forum.Entity.Rating;
import forum.services.rating.RatingServiceJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RatingController {

    @Autowired
    private RatingServiceJpa ratingService;
    @Autowired
    private UserController userController;

    public static void main(String[] args){

    }

    @RequestMapping("/rate")
    public String changeRating(Rating rating){
        if(rating.getValue() != 0 && userController.isLogged()){
            rating.setUserName(userController.getLoggedUserName());
            ratingService.changeRating(rating);
        }
        return "somewhere :)";
    }
}
