package models;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.mindrot.jbcrypt.BCrypt;
import play.data.validation.Constraints.Required;
import play.db.ebean.*;

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

    @NotNull
    @Required
    private double height;

    @NotNull
    @Required
    private double weight;

    @NotNull
    @Required
    private double waistline;

    @NotNull
    @Required
    private double hip;

    @NotNull
    @Required
    private int age;

    @NotNull
    @Required
    @Column(length = 10)
    private String gender;

    @NotNull
    @Required
    private boolean isGain;

    @NotNull
    @Required
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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