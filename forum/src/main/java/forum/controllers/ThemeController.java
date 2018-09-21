package forum.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import forum.services.rudeWords.RudeWordsService;
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
    private RudeWordsService rudeWordsService;
    @Autowired
    private ThemeService themeService;

    @Autowired
    private UserController userController;

    @Autowired
    private CategoryController categoryController;

    private String searchedTheme;


    @RequestMapping("/addTheme")
    public String addTheme(Theme theme) {
        if (theme != null && userController.isLogged()) {
            theme.setCategory(categoryController.getActualCategory());
            theme.setUser(userController.getLoggedUser());
            theme.setWhenCreated(new Date());
            String actual = theme.getTitle();
            theme.setTitle(changeeRudeWords(actual));
            themeService.addTheme(theme);
        }
        return "redirect:/";
    }

    @RequestMapping("/removeTheme")
    public String removeTheme(Long id) {
        if (id != null) {
            themeService.deleteTheme(id);
        }
        return "redirect:/";
    }

    public Theme getActualTheme() {

        return actualTheme;
    }

    @RequestMapping("/clickedTheme")
    public String clickedTheme(Long id) {
        actualTheme = themeService.getTheme(id);
        return "theme";
    }

    @RequestMapping("/searchTheme")
    public String searchTheme(String text) {
        searchedTheme = text;
        return "searchedTheme";
    }

    public String returnSearchedTheme() {
        System.out.println(searchedTheme);
        return searchedTheme;
    }

    public String changeeRudeWords(String string) {
        List<String> allRudeWords = new ArrayList<>();
        allRudeWords = rudeWordsService.allRudeWords();
        String input = string.toLowerCase();
        String output = "";
        String[] splited = string.split(" ");
        for (int i = 0; i < splited.length; i++) {
            for (String wordFromList : allRudeWords) {
                if (splited[i].contains(wordFromList)) {
                    int lenght = splited[i].length();
                    splited[i] = "";
                    for (int j = 0; j < lenght; j++) {
                        splited[i] += "*";
                    }
                }
            }
            output +=splited[i]+" ";
        }

        return output;

    }

}
