package rules.exercise.abs;

import rules.exercise.Exercise;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public abstract class AbsExercise implements Exercise {

    private String bodyPart = "Abs";
    private String name = "Abs Exercise";
    private String sets = "4";
    private String reps = "15-30";

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
