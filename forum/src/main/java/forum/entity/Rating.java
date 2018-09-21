package forum.entity;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
=======
import javax.persistence.*;
>>>>>>> a89cc6443aeb846a15d9839602a1b1c126225c19

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private long Id;


    private String userName;
    private String commentId;
    private int value;

<<<<<<< HEAD


    public Rating(String userName, String commentId, int value){
        this.userName = userName;
        this.commentId = commentId;
        this.value = value;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
=======
    private int value;



    public Rating(Comment  comment, User user, int value){
        this.user = user;
        this.comment = comment;
        this.value = value;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setValue(int value) {
        this.value = value;
>>>>>>> a89cc6443aeb846a15d9839602a1b1c126225c19
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

<<<<<<< HEAD
    public void setValue(int value) {
        this.value = value;
    }

    public String getCommentId() {
        return commentId;
    }

    public String getUserName() {
        return userName;
    }

=======
    public User getUser() {
        return user;
    }

>>>>>>> a89cc6443aeb846a15d9839602a1b1c126225c19
    public int getValue() {
        return value;
    }

    public long getId() {
        return Id;
    }
}
