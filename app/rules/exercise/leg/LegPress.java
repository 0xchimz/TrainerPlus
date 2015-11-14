package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class LegPress extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Leg Press";
    private String sets = "3";
    private String reps = "10-15";

    public LegPress() {
        this.setValue(name, sets, reps);
    }
}
