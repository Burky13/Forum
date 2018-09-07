package forum.services.theme;

import java.util.List;

import forum.entity.Theme;

public interface ThemeService {
    void addTheme(Theme theme);

    List<Theme> getThemeByCategory(String category);

    void editTheme(long id, String newThemeName);

    void deleteTheme(long id);

    void lock(long id);

    void unlock(long id);
}
