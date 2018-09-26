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
    public void addOrEditProfile(Profile profile,User user) {
        Profile p = null;
        System.out.println( profile.getUser());
        try {
            p = entityManager.createQuery("select p from Profile p where p.user = :user", Profile.class)
                    .setParameter("user",user)
                    .getSingleResult();
        } catch (NoResultException e) {}
        if(p != null) {
            System.out.println("voslo");
            p.change(profile);


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

    @Override
    public Profile getProfile(User user) {
        try{
            return entityManager.createQuery("Select p from Profile p where p.user= :user ",Profile.class)
                    .setParameter("user",user)
                    .getSingleResult();
        }catch(NoResultException e){

        }
        return  null;

    }

}
