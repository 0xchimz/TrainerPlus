package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Cardio rule", description = "Decision making on cardio activity")
public class CardioRule {

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
    public void notIntense() throws Exception {
        if (!isIntense) {
            result = "LISS & HIIT";
        }
    }

    @Action(order = 2)
    public void intense() throws Exception {
        if (isIntense) {
            result = "LISS";
        }
    }

    public void setInput(boolean isIntense) {
        this.isIntense = isIntense;
    }
    public String getResult() {
        return result;
    }
}
