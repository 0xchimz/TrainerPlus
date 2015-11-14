package rules.exercise.shoulder;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class DumbbellShoulderPress extends ShoulderExercise {

    private String bodyPart = "Shoulder";
    private String name = "Dumbbell Shoulder Press";
    private String sets = "4";
    private String reps = "10-15";

    public DumbbellShoulderPress() {
        this.setValue(name, sets, reps);
    }
}
