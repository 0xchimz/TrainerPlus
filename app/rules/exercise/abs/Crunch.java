package rules.exercise.abs;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class Crunch extends AbsExercise {

    private String bodyPart = "Abs";
    private String name = "Crunch";
    private String sets = "4";
    private String reps = "30";

    public Crunch() {
        this.setValue(name, sets, reps);
    }
}
