package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;

@Entity
@Table(name = "user_account")
public class User extends Model {
    @Id
    public Long id;
    public String name;

    // Finder will help us easily query data from database.
    public static Finder<Long, User> find =
            new Finder<Long, User>(Long.class, User.class);
}