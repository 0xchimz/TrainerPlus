package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class LegExtension extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Leg Extension";
    private String sets = "3";
    private String reps = "10-20";

    public LegExtension() {
        this.setValue(name, sets, reps);
    }
}
