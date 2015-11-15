package rules.exercise.abs;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class Plank extends AbsExercise {

    private String bodyPart = "Abs";
    private String name = "Plank";
    private String sets = "4";
    private String reps = "20 ~ 60s";

    public Plank() {
        this.setValue(name, sets, reps);
    }
}
