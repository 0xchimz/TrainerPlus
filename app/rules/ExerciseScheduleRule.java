package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import rules.exercise.Day;
import rules.exercise.Exercise;
import rules.exercise.ExerciseGenerator;

import java.util.ArrayList;

@Rule(name = "Exercise Schedule rule", description = "Generate the exercise schedule based on free-days")
public class ExerciseScheduleRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private int day;
    private boolean isIntense;
    private String gender;
    private ArrayList<Day> result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return day >= 2 && day <= 5 && (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female"));
    }

    @Action(order = 1)
    public void Intense() throws Exception {
        if (isIntense == true){
            if(gender.equalsIgnoreCase("male")) {
                result = new ExerciseGenerator().generate(day, true, false);
            }
            else {
                result = new ExerciseGenerator().generate(day, true, true);
            }
        }
    }
    
    @Action(order = 2)
    public void notIntense() throws Exception {
        if (isIntense == false){
            if(gender.equalsIgnoreCase("male")) {
                result = new ExerciseGenerator().generate(day, false, false);
            }
            else {
                result = new ExerciseGenerator().generate(day, false, true);
            }
        }
    }

    public void setInput(int day, boolean isIntense, String gender) {
    	this.day = day;
    	this.isIntense = isIntense;
        this.gender = gender;
    }

    public ArrayList<Day> getResult() {
        return result;
    }
}
