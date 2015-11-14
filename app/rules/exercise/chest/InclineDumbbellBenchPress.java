package rules.exercise.chest;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class InclineDumbbellBenchPress extends ChestExercise {

    private String bodyPart = "Chest";
    private String name = "Incline Dumbbell Bench Press";
    private String sets = "4";
    private String reps = "10-15";

    public InclineDumbbellBenchPress() {
        this.setValue(name, sets, reps);
    }
}

