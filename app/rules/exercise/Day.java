package rules.exercise;

import java.util.ArrayList;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class Day {
    private String day;
    private ArrayList<Exercise> exercises;

    public Day(String day, ArrayList<Exercise> exercises) {
        this.day = day;
        this.exercises = exercises;
    }

    public String getDay() {
        return this.day;
    }

    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }
}
