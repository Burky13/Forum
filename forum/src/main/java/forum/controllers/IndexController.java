package forum.controllers;

import forum.services.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class IndexController {
    @Autowired
    private CategoryService categoryService;


    @RequestMapping("/")
    public String index() {

        return "index";
    }


}
