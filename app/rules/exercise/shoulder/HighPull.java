package rules.exercise.shoulder;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class HighPull extends ShoulderExercise {

    private String bodyPart = "Shoulder";
    private String name = "High Pull";
    private String sets = "3";
    private String reps = "10";

    public HighPull() {
        this.setValue(name, sets, reps);
    }
}
