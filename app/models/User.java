package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import org.mindrot.jbcrypt.BCrypt;

import play.data.validation.Constraints;
import play.db.ebean.*;

@Entity
@Table(name = "user_account")
public class User extends Model {
    @Id
    public Long id;
    @NotNull
    @Constraints.Required
    @Column(unique=true)
    private String username;

    @NotNull
    @Constraints.Required
    private String password;


    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

    public static User findByUsername(String username){
        return find.setMaxRows(1).where().eq("username", username).findUnique();
    }
    public static User create(String username, String password, String fname,String lname, int type){
        if(User.find.where().eq("username", username).findUnique() == null) {
            User newUser = new User();
            newUser.username = username;
            newUser.password = BCrypt.hashpw(password, BCrypt.gensalt());
            newUser.save();
            return newUser;
        }
        return null;
    }
    public String getPassword() {
        return password;
    }
}