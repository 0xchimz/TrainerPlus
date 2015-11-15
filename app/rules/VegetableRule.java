package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import rules.nutrition.rawmaterial.meat.MeatGenerator;
import rules.nutrition.rawmaterial.vegetable.VegetableGenerator;

@Rule(name = "Nutrition_Vegetable rule", description = "Decision making on RawMaterial_Vegetable nutrition")
public class VegetableRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isVegetable;
    private VegetableGenerator result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return isVegetable;
    }

    @Action(order = 1)
    public void vegetable() throws Exception {
        result = new VegetableGenerator();
    }

    public void setInput(boolean isMeat) {
        this.isVegetable = isVegetable;
    }
    public VegetableGenerator getResult() {
        return result;
    }
}
