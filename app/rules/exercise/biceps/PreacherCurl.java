package rules.exercise.biceps;


/**
 * Created by Ong on 11/14/2015 AD.
 */
public class PreacherCurl extends BicepsExercise {

    private String bodyPart = "Biceps";
    private String name = "Preacher Curl";
    private String sets = "3";
    private String reps = "10-15";

    public PreacherCurl() {
        this.setValue(name, sets, reps);
    }
}
