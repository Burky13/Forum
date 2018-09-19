package forum.controllers;

import forum.entity.Category;
import forum.services.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CategoryController {

    @Autowired
    private UserController userController;
    @Autowired
    private CategoryService categoryService;

    private Category actualCategory;



    public String category() {

        return "/";
    }
    @RequestMapping("/addCategory")
    public String addCategory(Category category) {
        if (userController.adminLogged() || userController.moderatorLogged() && category != null) {
            categoryService.addCategory(category);
        }
        return "redirect:/";
    }

    public Category getActualCategory(){
        return actualCategory;
    }

    @RequestMapping("clickedCategory")
    public String clickedCategory(Long id){
        actualCategory = categoryService.getCategory(id);
        return "redirect:/";
    }

    @RequestMapping("/removeCategory")
    public String removeCategory(Long id){
        if(id != null){
            categoryService.deleteCategory(id);
        }
        return "redirect:/";
    }

public boolean isClicked(){
        return actualCategory !=null;
}
}
