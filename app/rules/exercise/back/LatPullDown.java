package rules.exercise.back;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class LatPullDown extends BackExercise {

    private String bodyPart = "Back";
    private String name = "Lat Pull-down";
    private String sets = "4";
    private String reps = "8-12";

    public LatPullDown() {
        this.setValue(name, sets, reps);
    }
}
