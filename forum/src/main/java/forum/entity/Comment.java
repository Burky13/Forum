package forum.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String text;
    private Date commentedOn;
    private String userName;
    private long topicId;
    private double rating;

    public Comment() {
    }

    public Comment(String text, Date commentedOn, String userName, long topicId, double rating) {
        this.text = text;
        this.commentedOn = commentedOn;
        this.userName = userName;
        this.topicId = topicId;
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public Date getCommentedOn() {
        return commentedOn;
    }

    public String getUserName() {
        return userName;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCommentedOn(Date commentedOn) {
        this.commentedOn = commentedOn;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public long getId() {
        return id;
    }
}

