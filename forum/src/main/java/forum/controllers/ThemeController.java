package forum.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import forum.entity.Theme;
import forum.services.theme.ThemeService;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ThemeController {


    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserController userController;


    @RequestMapping("/addTheme")
    public String addTheme(Theme theme) {
        if(theme.getCategory() !=null && userController.isLogged()) {
            theme.setUserName("Jozko");
            theme.setWhenW(new Date());
            themeService.addTheme(theme);
        }
        return "theme";
    }

    @RequestMapping("/removeTheme")
    public String removeTheme(Long id){
        if(id != null){
            themeService.deleteTheme(id);
        }
        return "theme";
    }

}
