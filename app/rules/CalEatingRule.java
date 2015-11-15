package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Calories Eating rule", description = "to gain or to lose.")
public class CalEatingRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private double TDEE;
    private boolean isGain;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return TDEE > 0;
    }

    @Action(order = 1)
    public void checkGain() throws Exception {
        if (isGain == true){
            double kcal = TDEE + (0.1*TDEE);
        	result = String.format("%.0f",kcal);
        }
    }
    
    @Action(order = 2)
    public void checkLose() throws Exception {
        if (isGain == false){
            double kcal = TDEE - (0.1*TDEE);
            result = String.format("%.0f",kcal);
        }
    }

    public void setInput(double TDEE, boolean isGain) {
        this.TDEE = TDEE;
        this.isGain = isGain;
    }
    public String getResult() {
        return result;
    }
}
