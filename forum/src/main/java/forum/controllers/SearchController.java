package forum.controllers;

import forum.services.Category.CategoryService;
import forum.services.theme.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;


@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class SearchController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ThemeController themeController;
    @Autowired
    private ThemeService themeService;

    @RequestMapping("/searchedTheme")
    public String searched() {



        return "searchedTheme";
    }


}
