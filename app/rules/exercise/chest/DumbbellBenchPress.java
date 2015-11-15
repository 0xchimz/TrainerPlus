package rules.exercise.chest;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class DumbbellBenchPress extends ChestExercise {

    private String bodyPart = "Chest";
    private String name = "Dumbbell Benchpress";
    private String sets = "4";
    private String reps = "10-15";

    public DumbbellBenchPress() {
        this.setValue(name, sets, reps);
    }
}
