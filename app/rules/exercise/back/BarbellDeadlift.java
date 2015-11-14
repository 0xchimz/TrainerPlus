package rules.exercise.back;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellDeadlift extends BackExercise {

    private String bodyPart = "Back";
    private String name = "Barbell DeadLift";
    private String sets = "4";
    private String reps = "8-12";

    public BarbellDeadlift() {
        this.setValue(name, sets, reps);
    }
}
