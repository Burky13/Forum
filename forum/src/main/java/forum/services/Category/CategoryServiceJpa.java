package forum.services.Category;

import forum.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
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
    @Transactional
    public void addCategory(Category category) {
            entityManager.persist(category);

    }

    @Override
    public Category getCategory(Long id) {
        return entityManager.createQuery("Select c from Category c where c.id:= id",Category.class)
                            .setParameter("id",id)
                .getSingleResult();

    }
}
