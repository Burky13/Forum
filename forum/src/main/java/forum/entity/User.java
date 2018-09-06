package forum.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(unique=true)
    private String userName;
    private String email;
    private String password;
    @Transient
    private String repeatPassword;
    private boolean admin;
    private boolean moderator;

    private User(){

    }

    public User(String userName, String password,  boolean admin, boolean moderator) {
        this.userName = userName;
        this.password = password;
        this.admin = admin;
        this.moderator = moderator;
    }


    public boolean validatePassword(){
        return password.equals(repeatPassword);
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
}
