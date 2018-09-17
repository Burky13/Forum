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
    private Theme actualTheme;

    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserController userController;

    @Autowired
    private CategoryController categoryController;

    @RequestMapping("/addTheme")
    public String addTheme(Theme theme) {
        if(theme !=null && userController.isLogged()) {

            theme.setCategory(categoryController.getActualCategory());

            theme.setUser(userController.getLoggedUser());

            theme.setWhenCreated(new Date());

            themeService.addTheme(theme);
        }
        return "redirect:/";
    }

    @RequestMapping("/removeTheme")
    public String removeTheme(Long id){
        if(id != null){
            themeService.deleteTheme(id);
        }
        return "theme";
    }

    public Theme getActualTheme() {

        return actualTheme;
    }
    @RequestMapping("/clickedTheme")
    public String clickedTheme(Long id){
        actualTheme = themeService.getTheme(id);
        return "theme";
    }
}
