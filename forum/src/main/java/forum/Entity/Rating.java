package forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private long Id;


    private String userName;
    private String commentId;
    private int value;



    public Rating(String userName, String commentId, int value){
        this.userName = userName;
        this.commentId = commentId;
        this.value = value;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCommentId() {
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
