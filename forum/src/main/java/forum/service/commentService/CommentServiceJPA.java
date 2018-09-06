package forum.service.commentService;

import forum.entity.Comment;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CommentServiceJPA implements CommentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addComment(Comment comment) {
        try{
            entityManager.persist(comment);
        } catch (Exception e) {
            throw new CommentException("Cannot save comment", e);
        }

    }

    @Override
    public List<Comment> getComments(String topic) {
        try{
            return entityManager.createQuery("select c from Comment c where c.topic = :topic order by c.commentedOn desc", Comment.class)
                    .setParameter("topic",topic)
                    .getResultList();
        }catch (Exception e) {
            throw new CommentException("Error getting comment for topic" + topic, e);
        }
    }
}
