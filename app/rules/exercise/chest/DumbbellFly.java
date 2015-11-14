package rules.exercise.chest;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class DumbbellFly extends ChestExercise {

    private String bodyPart = "Chest";
    private String name = "Dumbbell Fly";
    private String sets = "3";
    private String reps = "15";

    public DumbbellFly() {
        this.setValue(name, sets, reps);
    }
}

