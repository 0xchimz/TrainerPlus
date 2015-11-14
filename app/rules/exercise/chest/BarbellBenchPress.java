package rules.exercise.chest;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellBenchPress extends ChestExercise {

    private String bodyPart = "Chest";
    private String name = "Barbell Benchpress";
    private String sets = "4";
    private String reps = "10-15";

    public BarbellBenchPress() {
        this.setValue(name, sets, reps);
    }
}
