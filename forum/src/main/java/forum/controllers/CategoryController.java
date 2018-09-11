package forum.controllers;

import forum.entity.Category;
import forum.services.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CategoryController {

    @Autowired
    private UserController userController;
    @Autowired
    private CategoryService categoryService;

    private Category actualcategory;



    public String category() {

        return "/";
    }

    public String addCategory(Category category) {
        if (userController.adminLogged() && category != null) {
            categoryService.addCategory(category);
        }
        return "redirect:/";
    }

    public Category getActualcategory(){
        return actualcategory;
    }


}