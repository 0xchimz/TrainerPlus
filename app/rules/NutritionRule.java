package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import rules.nutrition.Carbohydrate;
import rules.nutrition.Fat;
import rules.nutrition.Nutrition;
import rules.nutrition.Protein;

import java.util.ArrayList;

@Rule(name = "Nutrition rule", description = "Decision making on Nutrition.")
public class NutritionRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isGain;
    private double weight;
    private ArrayList<Nutrition> result;

    private void init(double weight, boolean isGain) {
        this.isGain = isGain;
        this.weight = weight;
        result = new ArrayList<Nutrition>();
        result.add(new Protein(this.weight, this.isGain));
        result.add(new Carbohydrate(this.weight));
        result.add(new Fat(this.weight));
    }

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return weight > 0;
    }

    @Action(order = 1)
    public void notGain() throws Exception {
        if (isGain == false) {
            this.init(weight, isGain);
        }
    }

    @Action(order = 2)
    public void Gain() throws Exception {
        if (isGain == true) {
            this.init(weight, isGain);
        }
    }

    public void setInput(double weight, boolean isGain) {
        this.weight = weight;
        this.isGain = isGain;
    }
    public ArrayList<Nutrition> getResult() {
        return result;
    }
}
