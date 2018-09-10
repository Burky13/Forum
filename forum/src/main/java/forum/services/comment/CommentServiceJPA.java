package forum.services.comment;

import forum.entity.Comment;
import forum.entity.Theme;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public class CommentServiceJPA implements CommentService {

    @PersistenceContext
    private EntityManager entityManager;

    private Theme theme;

    @Override
    public void addComment(Comment comment) {
        try{
            entityManager.persist(comment);
        } catch (Exception e) {
            throw new CommentException("Cannot save comment", e);
        }

    }

    @Override
    public void removeComment(Long id) {
       Comment c = null;
       try {
           c = entityManager.createQuery("select id from Comment where id = :id", Comment.class)
                   .setParameter("id", id)
                   .getSingleResult();
       } catch (NoResultException e) {
       }
       if(c != null) {
           entityManager.remove(c);
       }
	}

	@Override
    public List<Comment> getComments(Long topicId) {
        try{
            return entityManager.createQuery("select c from Comment c where c.topicId = :topicId order by c.commentedOn desc", Comment.class)
                    .setParameter("topicId", topicId)
                    .getResultList();
        }catch (NoResultException e) {
            throw new CommentException("Error getting comment for theme" + theme.getTheme(), e);
        }
    }

    @Override
    public void editComment(Long id) {
        Comment c = null;
        try {
            c = entityManager.createQuery("select c from Comment c where c.id = :id", Comment.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
        }
        if(c != null) {
            entityManager.persist(c);
        }
    }
}
