package forum.entity;

import javax.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Comment comment;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
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
