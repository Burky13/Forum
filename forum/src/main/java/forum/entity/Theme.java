package forum.entity;

import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Theme implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    @Column(unique = true)
    private String theme;
    private String userName;
    private Date whenW;
    private String category;
    @ColumnDefault("false")
    private boolean isLocked;

    public Theme(){
    }

    public Theme(String theme, String userName, Date whenW, String category, boolean isLocked) {
        this.theme = theme;
        this.userName = userName;
        this.whenW = whenW;
        this.category = category;
        this.isLocked = isLocked;
    }

    public long getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getWhenW() {
        return whenW;
    }

    public void setWhenW(Date whenW) {
        this.whenW = whenW;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }
}
