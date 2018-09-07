package forum.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private long Id;


    private String userName;
    private long commentId;
    private int value;

    public Rating(){}

    public Rating(String userName, long commentId, int value){
        this.userName = userName;
        this.commentId = commentId;
        this.value = value;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public long getCommentId() {
        return commentId;
    }

    public String getUserName() {
        return userName;
    }

    public int getValue() {
        return value;
    }

    public long getId() {
        return Id;
    }
}
