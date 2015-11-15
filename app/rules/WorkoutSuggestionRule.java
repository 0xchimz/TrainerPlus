package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Workout Suggestion Rule", description = "Workout tips/trick")
public class WorkoutSuggestionRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isIntense;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return isIntense | !isIntense;
    }

    @Action(order = 1)
    public void intense() throws Exception {
        if (isIntense == true){
            result = "Rest between each sets around 40s ~ 60s";
        }
    }
    
    @Action(order = 2)
    public void notIntense() throws Exception {
        if(isIntense == false) {
            result = "Rest between each sets around 60s ~ 90s";
        }
    }

    public void setInput(boolean isIntense) {
        this.isIntense = isIntense;
    }
    public String getResult() {
        return result;
    }
}
