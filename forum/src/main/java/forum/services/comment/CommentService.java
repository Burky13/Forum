package forum.services.comment;

import forum.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    void removeComment(Long id);
    List<Comment> getComments(Long topic);
    void editComment (Long id);
}
