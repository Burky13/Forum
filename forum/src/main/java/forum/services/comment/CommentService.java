package forum.services.comment;

import forum.entity.Comment;
import forum.entity.Theme;
import forum.entity.User;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    void removeComment(Long id);
    List<Comment> getComments(Theme theme);
    void editComment (Long id,String text);
}
