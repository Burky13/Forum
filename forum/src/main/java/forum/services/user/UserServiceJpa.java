package forum.services.user;

import forum.entity.User;
import forum.services.user.UserService;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class UserServiceJpa implements UserService {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void register(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        User u = null;
        try{
            u = entityManager.createQuery("SELECT u FROM User u where u.id = :id",User.class)
                    .setParameter("id",id)
                    .getSingleResult();

        }catch(NoResultException e){

        }
        if(u!=null){
            entityManager.remove(u);
        }
    }

    @Override
    public User login(String userName, String password) {
        try{
            return  entityManager.createQuery("Select u from User u where u.userName= :userName and u.password = :password",User.class)
                    .setParameter("userName",userName)
                    .setParameter("password",password)
                    .getSingleResult();
        }catch(NoResultException e){

        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("Select u from User u ", User.class)
                .getResultList();

    }

    @Override
    public void changePassword(String userName, String email, String newPassword) {
        User u = null;
        try{
            u = entityManager.createQuery("Select u from User u where userName= :userName and email= :email and password= :newPassword",User.class)
                    .setParameter("userName",userName)
                    .setParameter("email",email)
                    .setParameter("password",newPassword)
                    .getSingleResult();
        }catch (NoResultException e){

        }
        if(u!=null){
            u.setPassword(newPassword);
        }
    }

    @Override
    public void newAdmin(Long id) {
        User u = null;
        try{
            u = entityManager.createQuery("SELECT u FROM User u where u.id = :id and u.admin= :admin",User.class)
                    .setParameter("id",id)
                    .setParameter("admin",false)
                    .getSingleResult();
        }catch(NoResultException e){

        }
        if(u!=null){
            u.setAdmin(true);
        }
    }

    @Override
    public void newModeraor(Long id) {
        User u = null;
        try{
            u = entityManager.createQuery("SELECT u FROM User u where u.id = :id and u.moderator= :moderator",User.class)
                    .setParameter("id",id)
                    .setParameter("moderator",false)
                    .getSingleResult();
        }catch(NoResultException e){

        }
        if(u!=null){
            u.setModerator(true);
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        User u = null;
        try{
            u = entityManager.createQuery("SELECT u FROM User u where u.id = :id and u.admin= :admin ",User.class)
                    .setParameter("id",id)
                    .setParameter("admin",true)
                    .getSingleResult();
        }catch(NoResultException e){

        }
        if(u!=null){
            u.setModerator(false);
        }
    }

    @Override
    public void deleteModerator(Long id) {
        User u = null;
        try{
            u = entityManager.createQuery("SELECT u FROM User u where u.id = :id and u.moderator= : moderator",User.class)
                    .setParameter("id",id)
                    .setParameter("moderator",true)
                    .getSingleResult();

        }catch(NoResultException e){

        }
        if(u!=null){
            u.setModerator(false);
        }
    }

}
