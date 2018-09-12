package forum.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "id",value = ConstraintMode.NO_CONSTRAINT))
    private Theme theme;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "id" , value = ConstraintMode.NO_CONSTRAINT))
    private User user;
    @Column(nullable =  false)
    private String text;
    @Column(nullable =  false)
    private Date date;

    public Comment (){

    }

    public Comment(Theme theme, User user, String text, Date date) {
        this.theme = theme;
        this.user = user;
        this.text = text;
        this.date = date;
    }

    public long getId() {
        return id;
    }


    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

