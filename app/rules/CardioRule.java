package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import rules.cardio.Cardio;
import rules.cardio.HIIT;
import rules.cardio.LISS;

import java.util.ArrayList;

@Rule(name = "Cardio rule", description = "Decision making on cardio activity")
public class CardioRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isIntense;
    private int age;
    private ArrayList<Cardio> result;

    private double maxHR;

    public void init() {
        maxHR = 220.0 - age;
    }

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return isIntense | !isIntense;
    }

    @Action(order = 1)
    public void notIntense() throws Exception {
        if (isIntense == false) {
            this.init();
            result = new ArrayList<Cardio>();
            result.add(new LISS(this.maxHR,false));
        }
    }

    @Action(order = 2)
    public void intense() throws Exception {
        if (isIntense == true) {
            this.init();
            result = new ArrayList<Cardio>();
            result.add(new LISS(this.maxHR,true));
            result.add(new HIIT(this.maxHR,true));
        }
    }

    public void setInput(int age, boolean isIntense) {
        this.age = age;
        this.isIntense = isIntense;
    }
    public ArrayList<Cardio> getResult() {
        return result;
    }
}
