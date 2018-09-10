package forum.entity;

import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
public class Theme implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Category category;

    @Column(nullable = false)
    private String title;
    @ColumnDefault("false")
    private boolean isLocked;
    private Date whenCreated;


    public Theme(){

    }

    public Theme(User user, Category category, String title, boolean isLocked, Date whenCreated) {
        this.user = user;
        this.category = category;
        this.title = title;
        this.isLocked = isLocked;
        this.whenCreated = whenCreated;
    }

    public long getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWhenCreated() {
        return whenCreated;
    }

    public void setWhenCreated(Date whenCreated) {
        this.whenCreated = whenCreated;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
