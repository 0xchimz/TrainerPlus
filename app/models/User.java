package models;

import javax.persistence.*;
import javax.validation.constraints.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.*;
import java.util.List;
import java.util.ArrayList;
@Entity
@Table(name = "user_account")
public class User extends Model {
    public final static int GUEST_USER = 1, NORMAL_USER = 2, ADMINISTRATOR = 3;
    @Id
    private Long id;

    @NotNull
    @Required
    @Column(unique=true)
    private String username;

    @NotNull
    @Required
    private String password;

    @NotNull
    @Required
    private String firstname;
    private String lastname;

    private static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

}
