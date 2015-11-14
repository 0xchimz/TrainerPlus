package rules;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "BMI rule", description = "check BMI")
public class BMIRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private double height;
    private double mass;
    private double bmi;
    private String result;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return (height > 0) & (mass > 0);
    }

    @Action(order = 1)
    public void checkBMI() throws Exception {
        bmi = mass / (height * height);
        result = String.format("BMI = %f %n", bmi);
    }
    
    @Action(order = 2)
    public void checkOverweight() throws Exception {
        if (bmi > 25)
            result = "You have an overweight";
    }

        @Action(order = 3)
    public void checkUnderweight() throws Exception {
        //if (Double.compare(bmi, 18.5) < 0)
        if (18.5 > bmi)
            result = "You have an underweight";
    }

        @Action(order = 4)
    public void checkNormalweight() throws Exception {
        if( (18.5 < bmi ) & (bmi < 25) )
            result = "You have a normal weight";
    }

    public void setInput(double height, double mass) {
        this.height = height;
        this.mass = mass;
    }

    public String getResult() {
        return result;
    }
}
