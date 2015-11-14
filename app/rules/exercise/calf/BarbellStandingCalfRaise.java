package rules.exercise.calf;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellStandingCalfRaise extends CalfExercise {

    private String bodyPart = "Calf";
    private String name = "Barbell Standing Calf Rises";
    private String sets = "4-5";
    private String reps = "15-20";

    public BarbellStandingCalfRaise() {
        this.setValue(name, sets, reps);
    }
}
