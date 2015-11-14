package rules.exercise.triceps;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class TricepsPushDown extends TricepsExercise {

    private String bodyPart = "Triceps";
    private String name = "Triceps Push Down";
    private String sets = "4";
    private String reps = "10-15";

    public TricepsPushDown() {
        this.setValue(name, sets, reps);
    }
}
