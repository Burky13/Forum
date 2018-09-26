package forum.entity;

import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="forum_user")
public class User implements Serializable {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique=true)
    private String userName;
    private String email;
    private String password;
    @Transient
    private String repeatPassword;
    @ColumnDefault("false")
    private boolean admin;
    @ColumnDefault("false")
    private boolean moderator;
    @ColumnDefault("false")
    private boolean blocked;
    private Date whenBlocked;
    @ColumnDefault("false")
    private boolean online;
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<Comment>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Theme> theme = new ArrayList<Theme>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Rating> rating = new ArrayList<Rating>();


    @OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Profile profile;

    private User(){

    }

    public User(String userName, String password,  boolean admin, boolean moderator) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.moderator = moderator;
    }


    public boolean validatePassword(){
        return password.equals(repeatPassword) ;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isModerator() {
        return moderator;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public void setModerator(boolean moderator) {
        this.moderator = moderator;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public Date getWhenBlocked() {
        return whenBlocked;
    }

    public void setWhenBlocked(Date whenBlocked) {
        this.whenBlocked = whenBlocked;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

}
