package rules.exercise.shoulder;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class SideLateralRaise extends ShoulderExercise {

    private String bodyPart = "Shoulder";
    private String name = "Side Lateral Raise";
    private String sets = "4";
    private String reps = "10-15";

    public SideLateralRaise() {
        this.setValue(name, sets, reps);
    }
}
