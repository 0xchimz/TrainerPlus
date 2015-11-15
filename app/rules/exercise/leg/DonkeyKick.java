package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class DonkeyKick extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Donkey Kick";
    private String sets = "4";
    private String reps = "20-30";

    public DonkeyKick() {
        this.setValue(name, sets, reps);
    }
}
