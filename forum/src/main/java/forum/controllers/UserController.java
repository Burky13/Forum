package forum.controllers;

import forum.bCrypt.BCrypt;
import forum.entity.User;
import forum.services.rudeWords.RudeWordsService;
import forum.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserController {
    @Autowired
    private RudeWordsService rudeWordsService;
    @Autowired
    private UserService userService;

    private BCrypt bCrypt;
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


        if(BCrypt.checkpw(password,userService.getPassword(userName)))
        loggedUser = userService.login(userName, password);

        if (loggedUser == null) {
            return "redirect:/";
        } else {
            System.out.println(loggedUser);
            return "redirect:/";
        }
    }
        return "login";

    }

    @RequestMapping("/register")
    public String register(User user){
        if(user.getUserName() !=null){
            if (check(user.getUserName().toLowerCase())) {
            if(user.validatePassword()) {


                    String hashedPass = bCrypt.hashpw(user.getPassword(), bCrypt.gensalt());
                    user.setPassword(hashedPass);
                    userService.register(user);
                    return "redirect:/";
                }
            }
        }
        return "register";

    }
    @RequestMapping("/logout")
    public String logout(){
        userService.logout(loggedUser.getId());
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
    public boolean isBlocked(){
        if(loggedUser==null)
            return false;

        return loggedUser.isBlocked();
    }

    public boolean check(String word){
        List<String> allRudeWords = new ArrayList<>();
        allRudeWords = rudeWordsService.allRudeWords();
        for (String wordFromList: allRudeWords){
            if(word.contains(wordFromList)){
                return false;
        }
        }
        return true;
    }

}
