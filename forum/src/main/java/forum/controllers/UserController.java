package forum.controllers;

import forum.entity.User;
import forum.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {


    @Autowired
    private UserService userService;

    private User loggedUser;

    public boolean isLogged(){
        return loggedUser !=null;
    }

    public String getLoggedUserName() {
        if (loggedUser != null) {
            return loggedUser.getUserName();
        } else {
            return "";
        }
    }
    public User getLoggedUser(){
        if(loggedUser!=null){
            return loggedUser;
        }else
            return null;
    }

    @RequestMapping("/login")
    public String login(String userName , String password){
    if(userName!=null && password!=null){
        loggedUser = userService.login(userName, password);
        if (loggedUser == null) {
            return "login";
        } else {
            System.out.println(loggedUser);
            return "register";
        }
    }
        return "login";

    }

    @RequestMapping("/register")
    public String register(User user){
        System.out.println("VOJDE??????");
        if(user.getUserName() !=null){
            System.out.println("VOJDE?");
            if(user.validatePassword()){
                userService.register(user);
                return "/";
            }
        }
        return "register";

    }
    @RequestMapping("/logout")
    public String logout(){
        loggedUser =null;
        return "index";
    }

    public boolean adminLogged() {
        if(loggedUser==null)
            return false;
        return loggedUser.isAdmin();
    }

    public boolean moderatorLogged() {
        if(loggedUser==null)
            return false;
        return loggedUser.isModerator();
    }



}
