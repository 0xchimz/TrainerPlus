package rules.exercise.abs;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class StandingBarbellTwist extends AbsExercise {

    private String bodyPart = "Abs";
    private String name = "Standing Barbell Twist";
    private String sets = "4";
    private String reps = "15-30";

    public StandingBarbellTwist() {
        this.setValue(name, sets, reps);
    }
}
