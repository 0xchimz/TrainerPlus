package rules.exercise.leg;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class SideLegRaise extends LegExercise {

    private String bodyPart = "Leg";
    private String name = "Side Leg Raise";
    private String sets = "4";
    private String reps = "20-30";

    public SideLegRaise() {
        this.setValue(name, sets, reps);
    }
}
