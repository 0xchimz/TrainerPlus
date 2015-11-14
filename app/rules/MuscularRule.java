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
    private boolean isDisorder;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return (isDisorder == true | isDisorder == false) & isGain == true;
    }

    @Action(order = 1)
    public void disOrder() throws Exception {
        if (isDisorder == true){
        	result = "You need a low-intensity training and gain weight";
        }
    }
    
    @Action(order = 2)
    public void notDisorder() throws Exception {
        if (isDisorder == false){
        	result = "You need to gain weight and weight training.";
        }
    }

    public void setInput(boolean isGain, boolean isDisorder) {
    	this.isGain = isGain;
    	this.isDisorder = isDisorder;
    }

    public String getResult() {
        return result;
    }
}
