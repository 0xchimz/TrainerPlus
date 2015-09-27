package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Obesity rule", description = "check you health.")
public class ObesityRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private String sex;
    private double waistPerHip;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return (sex.equalsIgnoreCase("male") | sex.equalsIgnoreCase("female")) & waistPerHip > 0;
    }

    @Action(order = 1)
    public void checkMale() throws Exception {
        if (sex.equalsIgnoreCase("male")) {
            if (waistPerHip > 0.95) {
                result = "You are at risk to obesity.";
            } else {
                result = "Your health is OK.";
            }
        }
    }

    @Action(order = 2)
    public void checkFemale() throws Exception {
        if (sex.equalsIgnoreCase("female")) {
            if (waistPerHip > 0.86) {
                result = "You are at risk to obesity.";
            } else {
                result = "Your health is OK.";
            }
        }
    }

    public void setInput(String sex, double waistPerHip) {
        this.sex = sex;
        this.waistPerHip = waistPerHip;
    }
    public String getResult() {
        return result;
    }
}
