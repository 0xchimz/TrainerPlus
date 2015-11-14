package rules.exercise.calf;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class SeatedCalfRaise extends CalfExercise {

    private String bodyPart = "Calf";
    private String name = "Seated Calf Raise";
    private String sets = "3";
    private String reps = "15-20";

    public SeatedCalfRaise() {
        this.setValue(name, sets, reps);
    }
}
