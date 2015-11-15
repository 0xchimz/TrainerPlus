package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class SumoSquat extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Sumo Squat";
    private String sets = "3";
    private String reps = "10-15";

    public SumoSquat() {
        this.setValue(name, sets, reps);
    }
}
