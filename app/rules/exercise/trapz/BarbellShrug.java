package rules.exercise.trapz;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class BarbellShrug extends TrapzExercise {

    private String bodyPart = "Trapz";
    private String name = "Barbell Shrugs";
    private String sets = "4-6";
    private String reps = "8-12";

    public BarbellShrug() {
        this.setValue(name, sets, reps);
    }
}
