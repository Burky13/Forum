package forum.services.theme;

import java.util.List;

import forum.entity.Category;
import forum.entity.Theme;

public interface ThemeService {
    void addTheme(Theme theme);

    List<Theme> getThemeByCategory(Category category);

    void editTheme(Long id, String newThemeName);

    void deleteTheme(Long id);

    void lock(Long id);

    void unlock(Long id);

    Theme getTheme (Long id);
}
