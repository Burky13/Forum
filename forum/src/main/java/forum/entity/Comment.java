package forum.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private long id;
    private String text;
    private Date commentedOn;
    private String userName;
    private String topic;

    public Comment() {
    }

    public Comment(String text, Date commentedOn, String userName, String topic) {
        this.text = text;
        this.commentedOn = commentedOn;
        this.userName = userName;
        this.topic = topic;
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

    public String getTopic() {
        return topic;
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

    public void setTopic(String topic) {
        this.topic = topic;
    }
}

