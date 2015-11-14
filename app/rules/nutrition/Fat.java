package rules.nutrition;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class Fat implements Nutrition {

    private String name = "Fat";
    private double normalAmountFactor = 0.5;
    private double normalAmount;
    private String amount;

    public Fat(double weight) {
        normalAmount = 2.2 * weight * normalAmountFactor;
        this.amount = String.format("%.0f g /day", normalAmount);
    }

    public String getName() {
        return this.name;
    }

    public String getAmount() {
        return this.amount;
    }
}
