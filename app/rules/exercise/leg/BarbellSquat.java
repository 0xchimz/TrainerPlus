package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellSquat extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Barbell Squat";
    private String sets = "3";
    private String reps = "8-15";

    public BarbellSquat() {
        this.setValue(name, sets, reps);
    }
}
