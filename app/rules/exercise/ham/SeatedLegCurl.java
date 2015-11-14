package rules.exercise.ham;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class SeatedLegCurl extends HamExercise {

    private String bodyPart = "Ham";
    private String name = "Seated Leg Curl";
    private String sets = "4";
    private String reps = "10-15";

    public SeatedLegCurl() {
        this.setValue(name, sets, reps);
    }
}
