package forum.services.Category;

import forum.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CategoryServiceJpa implements  CategoryService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Category> getAllCategories() {
        return entityManager.createQuery("Select c from Category c", Category.class).getResultList();

    }

    @Override

    public void addCategory(Category category) {
            entityManager.persist(category);

    }

    @Override
    public Category getCategory(Long id) {
        System.out.println(id);
        try {
            return entityManager.createQuery("Select c from Category c where c.id= :id", Category.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }catch(NoResultException e){

        }
        return null;

    }
}
