package rules.exercise.triceps;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class TricepsExtension extends TricepsExercise {

    private String bodyPart = "Triceps";
    private String name = "Triceps Extension";
    private String sets = "4";
    private String reps = "10-15";

    public TricepsExtension() {
        this.setValue(name, sets, reps);
    }
}
