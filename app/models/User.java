package models;

import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

import org.joda.time.*;
import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints.Required;
import play.db.ebean.*;
import play.data.format.*;

@Entity
@Table(name = "user_account")
public class User extends Model {
    @Id
    public long id;
    @NotNull
    @Required
    @Column(unique=true)
    private String email;

    @NotNull
    @Required
    private String password;

    @Column(nullable = true)
    private double height;

    @Column(nullable = true)
    private double weight;

    @Column(nullable = true)
    private double waistline;

    @Column(nullable = true)
    private double hip;

    @NotNull
    @Required
    @Formats.DateTime(pattern="dd/MM/yyyy")
    private Date birthday = new Date();

    @NotNull
    @Required
    @Column(length = 10)
    private String gender;

    @Column(nullable = true)
    private boolean isGain;

    @Column(nullable = true)
    private int userWorkoutDays;
    private boolean workoutIsIntense;
    private boolean cardioIsIntense;

    public double getHip() {
        return hip;
    }

    public void setHip(double hip) {
        this.hip = hip;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWaistline() {
        return waistline;
    }

    public void setWaistline(double waistline) {
        this.waistline = waistline;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isGain() {
        return isGain;
    }

    public void setIsGain(boolean isGain) {
        this.isGain = isGain;
    }

    public int getUserWorkoutDays() {
        return userWorkoutDays;
    }

    public void setUserWorkoutDays(int userWorkoutDays) {
        this.userWorkoutDays = userWorkoutDays;
    }

    public boolean isWorkoutIsIntense() {
        return workoutIsIntense;
    }

    public void setWorkoutIsIntense(boolean workoutIsIntense) {
        this.workoutIsIntense = workoutIsIntense;
    }

    public boolean isCardioIsIntense() {
        return cardioIsIntense;
    }

    public void setCardioIsIntense(boolean cardioIsIntense) {
        this.cardioIsIntense = cardioIsIntense;
    }

    public static Finder<Long, User> getFind() {
        return find;
    }

    public static void setFind(Finder<Long, User> find) {
        User.find = find;
    }

    public int getAge() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.birthday);
        LocalDate birthdate = new LocalDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
        LocalDate now = new LocalDate();
        int age = Years.yearsBetween(birthdate, now).getYears();
        return age;
    }

    public static Finder<Long, User> find = new Finder<Long, User>(Long.class, User.class);

    public static User findByEmail(String email){
        return find.setMaxRows(1).where().eq("email", email).findUnique();
    }
    public static User findById(Long id){
        return find.byId(id);
    }
    public static User create(String email, String password){
        if(User.find.where().eq("email", email).findUnique() == null) {
            User newUser = new User();
            newUser.email = email;
            newUser.password = BCrypt.hashpw(password, BCrypt.gensalt());
            newUser.save();
            return newUser;
        }
        return null;
    }
    public String getPassword() {
        return password;
    }
    public long getId() {
        return id;
    }
}