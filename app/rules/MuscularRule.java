package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Muscular rule", description = "check if you want to be more muscular or not")
public class MuscularRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isGain;
    private boolean isIntense;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return (isIntense == true | isIntense == false) & isGain == true;
    }

    @Action(order = 1)
    public void disOrder() throws Exception {
        if (isIntense == false){
        	result = "You need to gain weight and workout";
        }
    }
    
    @Action(order = 2)
    public void notDisorder() throws Exception {
        if (isIntense == true){
        	result = "You need to gain weight and weight training.";
        }
    }

    public void setInput(boolean isGain, boolean isIntense) {
    	this.isGain = isGain;
    	this.isIntense = isIntense;
    }

    public String getResult() {
        return result;
    }
}
