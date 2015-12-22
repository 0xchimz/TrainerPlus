package models;

import org.joda.time.DateTime;
import play.db.ebean.Model;
import play.db.ebean.*;
import javax.persistence.*;
import java.util.List;

/**
 * Created by Frank on 12/22/15 AD.
 */
@Entity
@Table(name = "weight_history")
public class WeightHistory extends Model {

    @Id
    public long id;

    @Column(nullable = false)
    private double weight;

    @ManyToOne
    @Column(nullable = false)
    private User user;

    @Column(nullable = false)
    private DateTime added = new DateTime ();

    public WeightHistory(double weight, User user){
        this.weight = weight;
        this.user = user;
    }
    public static Model.Finder<Long, WeightHistory> find = new Model.Finder<Long, WeightHistory>(Long.class, WeightHistory.class);

    public static Model.Finder<Long, WeightHistory> getFind() {
        return find;
    }

    public static void setFind(Model.Finder<Long, User> find) {
        User.find = find;
    }

    public static List<WeightHistory> findByUser(User user){
        return find.where().eq("user", user).findList();
    }

    public static void saveByUser(User user){
        WeightHistory weightHistory = new WeightHistory(user.getWeight(), user);
        weightHistory.save();
    }

}
