package forum.controllers;

import forum.entity.Profile;
import forum.services.profile.ProfileService;
import forum.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ProfileController {

    @Autowired
    private UserService userService;
    @Autowired
    UserController userController;

    @Autowired
    ProfileService profileService;

    Profile actualProfile;

    @RequestMapping("/profile")
    public String addProfile(Profile profile) {
        System.out.println("KOKOTINA");
        if(profile != null && userController.isLogged()) {
      //      System.out.println(profile.getBirthday());
            System.out.println(profile.getCellPhone());
            System.out.println(profile.getFirstName());
        //    System.out.println(profile.getTwitter());
            System.out.println(profile.getLastName());
            System.out.println(profile.getCity());
            profile.setUser(userController.getLoggedUser());
            profileService.addOrEditProfile(profile);
        }return "profile";
    }
}
