package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Exercise Schedule rule", description = "Generate the exercise schedule based on free-days")
public class ExerciseScheduleRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private int day;
    private boolean isIntense;
    private String gender;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return day >= 2 && day <= 5;
    }

    @Action(order = 1)
    public void Intense() throws Exception {
        if (isIntense == true){
        	result = "generate Exercise Schedule";
        }
    }
    
    @Action(order = 2)
    public void notIntense() throws Exception {
        if (isIntense == false){
        	result = "generate Exercise Schedule";
        }
    }

    public void setInput(int day, boolean isIntense, String gender) {
    	this.day = day;
    	this.isIntense = isIntense;
        this.gender = gender;
    }

    public String getResult() {
        return result;
    }
}
