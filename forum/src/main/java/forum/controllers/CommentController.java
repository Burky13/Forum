package forum.controllers;

import forum.entity.Comment;
import forum.entity.Theme;
import forum.services.comment.CommentService;
import forum.services.theme.ThemeService;
import forum.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@Controller
@Scope(WebApplicationContext.SCOPE_SESSION)
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @Autowired
    UserController userController;

    Theme theme;

    @RequestMapping("/theme")
    public String theme() {
        return "theme";
    }

    @RequestMapping("/addComment")
    public String addComment(Comment comment) {
        if (comment.getText() != null && userController.isLogged()) {
            comment.setUser(userController.getLoggedUserName());
            comment.setDate(new Date());
            comment.setTheme(theme);
            commentService.addComment(comment);
        }
        return "theme";
    }

    @RequestMapping("/removeComment")
    public String removeComment(Long id) {
        if (id != null) {
            commentService.removeComment(id);
        }
        return "theme";
    }

    @RequestMapping("/editComment")
    public String editComment(Long id) {
        if(id != null) {
            commentService.editComment(id);
        }
        return "theme";
    }
}
