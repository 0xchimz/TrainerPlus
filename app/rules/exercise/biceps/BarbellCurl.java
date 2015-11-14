package rules.exercise.biceps;


/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellCurl extends BicepsExercise {

    private String bodyPart = "Biceps";
    private String name = "Barbell Curl";
    private String sets = "4";
    private String reps = "8-12";

    public BarbellCurl() {
        this.setValue(name, sets, reps);
    }
}
