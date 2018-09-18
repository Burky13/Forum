package forum.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Profile implements Serializable {

    @Id
    @Column(name = "user")
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @Column(length = 30)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(length = 15)
    private String cellPhone;

    @Column
    private Date birthday;

    @Column
    private boolean male;
}
