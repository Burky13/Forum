package forum.services.profile;

import forum.entity.Profile;
import forum.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class ProfileServiceJPA implements ProfileService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addOrEditProfile(Profile profile) {
        Profile p = null;
        try {
            p = entityManager.createQuery("select p from Profile p where p.user = :user", Profile.class)
                    .setParameter("user", profile.getUser())
                    .getSingleResult();
        } catch (NoResultException e) {}
        if(p != null) {
            entityManager.remove(p);
            entityManager.persist(profile);
        }else {
            entityManager.persist(profile);
        }
    }

    @Override
    public Profile showProfile(User user) {
        try {
            return entityManager.createQuery("select p from Profile p where p.user = :user", Profile.class)
                    .setParameter("user", user)
                    .getSingleResult();

        }catch (NoResultException e) {
        }
        return null;
    }
}
