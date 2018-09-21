package forum.entity;

import javax.persistence.*;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "id" , value = ConstraintMode.NO_CONSTRAINT))
    private Comment comment;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(foreignKey = @ForeignKey(name = "id" , value = ConstraintMode.NO_CONSTRAINT))
    private User user;

    private int value;


    public Rating(){}

    public Rating(Comment  comment, User user, int value){
        this.user = user;
        this.comment = comment;
        this.value = value;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Comment getComment() {
        return comment;
    }

    public User getUser() {
        return user;
    }

    public int getValue() {
        return value;
    }

    public long getId() {
        return Id;
    }
}
