package forum.services.rudeWords;

import forum.entity.RudeWords;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class RudeWordsServiceJpa  implements  RudeWordsService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RudeWords> getAllWords() {
       try{
           return entityManager.createQuery("Select w from RudeWords w",RudeWords.class).getResultList();
       }catch (NoResultException e){

       }
       return null;
    }

    @Override
    public void addWord(RudeWords rudeWords) {
    try{
        entityManager.persist(rudeWords);
    }catch(Exception e){

    }

    }

    @Override
    public void delete(Long id) {
    RudeWords rW = null;
    try{
        rW = entityManager.createQuery("Select w from RudeWords w where id = :id",RudeWords.class)
                .setParameter("id",id)
                .getSingleResult();
    }catch (NoResultException e){

    }
    if(rW!=null){
        entityManager.remove(rW);
    }
    }

    @Override
    public boolean findWord(String word) {
       String s = null;
       try{
           s = entityManager.createQuery("Select w.rudeWord from RudeWords w where w.rudeWord like :word",String.class)
                   .setParameter("word","%"+word+"%")
                   .getSingleResult();

       }catch(NoResultException e){

       }
       if(s !=null){
           return true;


       }
       return false;
    }

    @Override
    public List<String> allRudeWords() {
        try{
            return entityManager.createQuery("Select w.rudeWord from RudeWords w",String.class).getResultList();
        }catch (NoResultException e){

        }
        return null;
    }


}
