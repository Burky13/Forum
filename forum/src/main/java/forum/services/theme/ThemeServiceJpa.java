package forum.services.theme;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.NoResultException;
import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import forum.entity.Theme;
import java.util.List;

@Transactional
public class ThemeServiceJpa implements ThemeService {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addTheme(Theme theme) {
        try {
            entityManager.persist(theme);
        } catch (Exception e) {
            throw new ThemeException("Cannot save theme", e);

        }
    }

    @Override
    public List<Theme> getThemeByCategory(String category) {
        try {
            return entityManager.createQuery("select t from Theme t where t.category= :category", Theme.class)
                    .setParameter("category", category)
                    .getResultList();
        } catch (NoResultException e){
        } return null;
    }

    @Override
    public void editTheme(long id, String newThemeName) {
        Theme t = null;
        try{
            t = entityManager.createQuery("select t from Theme t where t.id= :id", Theme.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e){
        }
        if (t != null){
            t.setTheme(newThemeName);
        }
    }

    @Override
    public void deleteTheme(long id) {
        Theme t = null;
        try{
            t = entityManager.createQuery("select t from Theme t where t.id= :id", Theme.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e){
        }
        if (t != null){
            entityManager.remove(t);
        }
    }

    @Override
    public void lock(long id) {
        Theme t = null;
        try{
            t = entityManager.createQuery("select t from Theme t where t.id= :id", Theme.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e){
        }
        if (t != null){
            t.setLocked(true);
        }
    }

    @Override
    public void unlock(long id) {
        Theme t = null;
        try {
            t = entityManager.createQuery("select t from Theme t where t.id= :id", Theme.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        if (t != null) {
            t.setLocked(false);
        }
    }

}
