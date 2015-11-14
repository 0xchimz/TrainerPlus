package rules.exercise.back;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BackExtension extends BackExercise {

    private String bodyPart = "Back";
    private String name = "Back Extension";
    private String sets = "4";
    private String reps = "15-20";

    public BackExtension() {
        this.setValue(name, sets, reps);
    }
}
