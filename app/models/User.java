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
    public Long id;
    @NotNull
    @Required
    @Column(unique=true)
    private String email;

    @NotNull
    @Required
    private String password;

    @NotNull
    @Required
    @Column(length = 10)
    private Double height;

    @NotNull
    @Required
    @Column(length = 10)
    private Double weight;

    @NotNull
    @Required
    @Column(length = 10)
    private Double waistline;

    @NotNull
    @Required
    @Column(length = 10)
    private Double hip;

    @NotNull
    @Required
    @Column(length = 5)
    private Integer age;

    @NotNull
    @Required
    @Column(length = 10)
    private String gender;

    @NotNull
    @Required
    private boolean isGain;

    @NotNull
    @Required
    private Integer userWorkoutDays;
    private boolean workoutIsIntense;
    private boolean cardioIsIntense;

    public Double getHip() {
        return hip;
    }

    public void setHip(Double hip) {
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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getWaistline() {
        return waistline;
    }

    public void setWaistline(Double waistline) {
        this.waistline = waistline;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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

    public Integer getUserWorkoutDays() {
        return userWorkoutDays;
    }

    public void setUserWorkoutDays(Integer userWorkoutDays) {
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

    public static User findByUsername(String username){
        return find.setMaxRows(1).where().eq("username", username).findUnique();
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
    public Long getId() {
        return id;
    }
}