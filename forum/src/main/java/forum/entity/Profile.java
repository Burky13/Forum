package forum.entity;

import com.sun.istack.internal.Nullable;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Profile implements Serializable {

    @Id
    private long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "id",value = ConstraintMode.NO_CONSTRAINT))
    private User user;

    @Column(length = 30, nullable = true)
    private String firstName;

    @Column(length = 50, nullable = true)
    private String lastName;

    @Column(length = 50, nullable = true)
    private String city;

    @Column(length = 15, nullable = true)
    private String cellPhone;

    @Column(nullable = true)
    private Date birthday;


    @ColumnDefault("true")
    private boolean male;

    @Column
    private int comments;

    @Column (length = 500, nullable = true)
    private String hobbies;

    @Column (length = 30, nullable = true)
    private String skype;

    @Column (length = 30, nullable = true)
    private String facebook;

    @Column (length = 30, nullable = true)
    private String twitter;

    @Column (length = 30, nullable = true)
    private String instagram;

    @Column (length = 30, nullable = true)
    private String whatsapp;

    @Column (length = 30, nullable = true)
    private String linkedIn;

    public Profile(){}

    public Profile(User user, String firstName, String lastName, String city, String cellPhone, Date birthday, boolean male, int comments, String hobbies, String skype, String facebook, String twitter, String instagram, String whatsapp, String linkedIn) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.cellPhone = cellPhone;
        this.birthday = birthday;
        this.male = male;
        this.comments = comments;
        this.hobbies = hobbies;
        this.skype = skype;
        this.facebook = facebook;
        this.twitter = twitter;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
        this.linkedIn = linkedIn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
