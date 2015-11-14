package rules.exercise.back;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellRow extends BackExercise {

    private String bodyPart = "Back";
    private String name = "Barbell Row";
    private String sets = "4";
    private String reps = "8-12";

    public BarbellRow() {
        this.setValue(name, sets, reps);
    }
}
