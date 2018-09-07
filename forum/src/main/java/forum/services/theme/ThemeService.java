package forum.services.theme;

import java.util.List;

import forum.entity.Theme;

public interface ThemeService {
    void addTheme(Theme theme);

    List<Theme> getThemeByCategory(String category);

    void editTheme(Long id, String newThemeName);

    void deleteTheme(Long id);

    void lock(Long id);

    void unlock(Long id);
}
