package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import rules.cardio.Cardio;
import rules.cardio.HIIT;
import rules.cardio.LISS;
import rules.nutrition.rawmaterial.meat.MeatGenerator;

import java.util.ArrayList;

@Rule(name = "Nutrition_Meat rule", description = "Decision making on RawMaterial_Meat nutrition")
public class MeatRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isMeat;
    private MeatGenerator result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return isMeat;
    }

    @Action(order = 1)
    public void meat() throws Exception {
        result = new MeatGenerator();
    }

    public void setInput(boolean isMeat) {
        this.isMeat = isMeat;
    }
    public MeatGenerator getResult() {
        return result;
    }
}
