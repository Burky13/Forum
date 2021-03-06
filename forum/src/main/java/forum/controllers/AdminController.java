package forum.controllers;


import forum.entity.RudeWords;
import forum.services.rudeWords.RudeWordsService;
import forum.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class AdminController {

    @Autowired
    private RudeWordsService rudeWordsService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserController userController;


    @RequestMapping("/admin")
    public String login() {

        return "admin";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Long id) {
        if(id !=null ) {
            userService.deleteUser(id);
        }

        return "redirect:/admin";
    }
    @RequestMapping("/changeAdminPrivileges")
    public String changeAdminPrivileges(Long id) {
        if(id !=null ) {
            userService.changeAdminPrivileges(id);
        }
        return "redirect:/admin";
    }
    @RequestMapping("/changeModeratorPrivileges")
    public String changeModeratorPrivileges(Long id) {
        if(id !=null ) {
            userService.changeModeratorPrivileges(id);
        }
        return "redirect:/admin";
    }
    @RequestMapping("/blockUnBlock")
    public String blockAndUnblock(Long id) {
        if (id != null) {
            userService.blockAndUnblock(id);
        }
        return "redirect:/admin";
    }

    @RequestMapping("/addRudeWord")
    public String addRudeWord(RudeWords word){
        if(word !=null){
            rudeWordsService.addWord(word);
        }
        return  "redirect:/admin";
    }
    @RequestMapping("/deleteWord")
    public String deleteRudeWord(Long id ){
        rudeWordsService.delete(id);
        return "redirect:/admin";
    }


}
