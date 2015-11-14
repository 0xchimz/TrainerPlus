package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Cardio Judgement rule", description = "Decision making whether to cardio or not")
public class CardioJudgementRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private String goal;
    private boolean trainHeart;
    private boolean result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return (goal.equalsIgnoreCase("gain") | goal.equalsIgnoreCase("lose"));
    }

    @Action(order = 1)
    public void checkGain() throws Exception {
        if (goal.equalsIgnoreCase("gain") && trainHeart == true){
        	result = true;
        }
    }
    
    @Action(order = 2)
    public void checkLose() throws Exception {
        if (goal.equalsIgnoreCase("lose")){
        	result = true;
        }
    }

    public void setInput(String goal) {
        this.goal = goal;
    }
    public boolean getResult() {
        return result;
    }
}
