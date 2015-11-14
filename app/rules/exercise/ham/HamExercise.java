package rules.exercise.ham;

import rules.exercise.Exercise;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public abstract class HamExercise implements Exercise {

    private String bodyPart = "Ham";
    private String name = "Ham Exercise";
    private String sets = "3";
    private String reps = "8-15";

    public String getBodyPart() {
        return this.bodyPart;
    }

    public String getName() {
        return this.name;
    }

    public String getSets() {
        return this.sets;
    }

    public String getReps() {
        return this.reps;
    }

    public void setValue(String name, String sets, String reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
    }
}
