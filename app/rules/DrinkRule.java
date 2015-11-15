package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import rules.nutrition.rawmaterial.drink.DrinkGenerator;

@Rule(name = "Nutrition_Drink rule", description = "Decision making on RawMaterial_Drink nutrition")
public class DrinkRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isDrink;
    private DrinkGenerator result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return isDrink;
    }

    @Action(order = 1)
    public void drink() throws Exception {
        result = new DrinkGenerator();
    }

    public void setInput(boolean isDrink) {
        this.isDrink = isDrink;
    }
    public DrinkGenerator getResult() {
        return result;
    }
}
