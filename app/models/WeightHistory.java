package models;

import org.joda.time.DateTime;
import play.data.format.Formats;
import play.db.ebean.Model;
import play.db.ebean.*;
import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Formats.DateTime(pattern="dd/MM/yyyy")
    private Date added = new Date();

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

    public static WeightHistory findByDate(Date date, User user){
        Date date1 = new Date();
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        System.out.println(date1);
        System.out.println(date);
        return find.where().between("added", date, date1).eq("user", user).findUnique();
    }

    public static void saveByUser(User user){
        WeightHistory temp = findByDate(new Date(), user);
        System.out.println(temp);
        if (temp!=null) {
            temp.delete();
            WeightHistory weightHistory = new WeightHistory(user.getWeight(), user);
            weightHistory.save();
        }
        WeightHistory weightHistory = new WeightHistory(user.getWeight(), user);
        weightHistory.save();

    }

    public long getId() {
        return id;
    }

    public double getWeight() {
        return weight;
    }

    public User getUser() {
        return user;
    }

    public String getAdded() {
        return new SimpleDateFormat("yyyy-MM-dd").format(added);
    }
}
