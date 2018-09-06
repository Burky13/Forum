package forum.service;

import forum.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    List<Comment> getComments(String topic);
}
