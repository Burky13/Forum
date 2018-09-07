package forum.controllers;


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
    private UserService userService;
    @Autowired
    private UserController userController;


    @RequestMapping("/admin")
    public String login() {

        return "admin";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Long id) {
        if(id !=null && !userService.isAdmin(id) ) {
            userService.deleteUser(id);
        }

        return "redirect:/admin";
    }

    @RequestMapping("/addAdmin")
    public String addAdmin(Long id) {
        if(id!=null){
            userService.newAdmin(id);
        }
        return "redirect:/admin";
    }


}
