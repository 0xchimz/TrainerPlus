package rules.exercise.ham;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellStiffLegDeadlift extends HamExercise {

    private String bodyPart = "Ham";
    private String name = "Barbell Stiff Leg Deadlift";
    private String sets = "3";
    private String reps = "10-15";

    public BarbellStiffLegDeadlift() {
        this.setValue(name, sets, reps);
    }
}
