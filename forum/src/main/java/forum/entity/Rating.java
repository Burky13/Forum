package forum.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Rating implements Serializable {
    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "id" , value = ConstraintMode.NO_CONSTRAINT))
    private Comment comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(foreignKey = @ForeignKey(name = "id" , value = ConstraintMode.NO_CONSTRAINT))
    private User user;

    private int rating;


    public Rating(){}

    public Rating(Comment comment, User user, int rating){
        this.comment = comment;
        this.user = user;
        this.rating = rating;
    }

    public long getId() {
        return Id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
