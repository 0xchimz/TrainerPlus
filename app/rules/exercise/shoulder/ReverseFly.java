package rules.exercise.shoulder;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class ReverseFly extends ShoulderExercise {

    private String bodyPart = "Shoulder";
    private String name = "ReverseFly";
    private String sets = "4";
    private String reps = "10-15";

    public ReverseFly() {
        this.setValue(name, sets, reps);
    }
}
