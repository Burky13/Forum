package forum.controllers;

import forum.entity.Profile;
import forum.entity.User;
import forum.services.profile.ProfileService;
import forum.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    User actualUser;
    Profile actualProfile;

    @RequestMapping("/profile")
    public String profile(Model model) {
        if (userController.isLogged()) {
            actualUser =userController.getLoggedUser();
            Profile profile =  profileService.showProfile(userController.getLoggedUser());
            model.addAttribute("profile", profile);
        }
        return "profile";
    }

    @RequestMapping("/updateprofile")
    public String addProfile(Profile profile) {
        if (profile != null && userController.isLogged()) {
            //      System.out.println(profile.getBirthday());
            System.out.println(profile.getCellPhone());
            System.out.println(profile.getFirstName());
            //    System.out.println(profile.getTwitter());
            System.out.println(profile.getLastName());
            System.out.println(profile.getCity());
            profile.setUser(userController.getLoggedUser());
            long id = userController.getLoggedUser().getId();
            System.out.println(userController.getLoggedUser().getId());
            profileService.addOrEditProfile(profile, userService.getUser(id));
        }
        return "profile";
    }

    @RequestMapping("/clickedUser")
    public String clickedUser(Long id, Model model) {
        Profile actualeProfile =profileService.getProfile(userService.getUser(id));
        model.addAttribute("profile", actualeProfile);
        model.addAttribute("profileFirst", actualeProfile.getFirstName());
        model.addAttribute("profileLast", actualeProfile.getLastName());
        model.addAttribute("profileCellPhone", actualeProfile.getCellPhone());
        model.addAttribute("profileCity", actualeProfile.getCity());
        model.addAttribute("profileHobbies", actualeProfile.getHobbies());
        model.addAttribute("profileFacebook", actualeProfile.getFacebook());
        model.addAttribute("profileInstagram", actualeProfile.getInstagram());
        model.addAttribute("profileLinkedIn", actualeProfile.getLinkedIn());
        model.addAttribute("profileSkype", actualeProfile.getSkype());
        model.addAttribute("profileTwitter", actualeProfile.getTwitter());
        model.addAttribute("profileWhatsApp", actualeProfile.getWhatsapp());
        model.addAttribute("profileMale", actualeProfile.isMale());
        actualUser= userService.getUser(id);
        return "profile";
    }

    public boolean clickedUserEqualsLoggedUser() {
        if(userController.getLoggedUser()==null){
            return false;
        }
        if(actualUser == null)
            return false;
        return actualUser.getId() == userController.getLoggedUser().getId();
    }

    public Profile clickedUserProfile() {
    return null;
        //return profileService.getProfile(actualUser.getId());
    }
}
