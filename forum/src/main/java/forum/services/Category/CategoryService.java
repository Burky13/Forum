package forum.services.Category;

import forum.entity.Category;
import sun.swing.SwingUtilities2;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();
    void addCategory(Category category);

}
