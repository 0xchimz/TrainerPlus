package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class WalkingLunge extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Walking Lunge";
    private String sets = "3";
    private String reps = "10-15";

    public WalkingLunge() {
        this.setValue(name, sets, reps);
    }
}
