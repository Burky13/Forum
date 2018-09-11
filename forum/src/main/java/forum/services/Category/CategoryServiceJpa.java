package forum.services.Category;

import forum.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.concurrent.CancellationException;

public class CategoryServiceJpa implements  CategoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getAllCategories() {
        return entityManager.createQuery("Select c from Category c", Category.class).getResultList();

    }

    @Override
    public void addCategory(Category category) {
        if(category!=null){
            entityManager.persist(category);
        }
    }
}
