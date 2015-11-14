package rules.nutrition;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class Carbohydrate implements Nutrition {

    private String name = "Carbohydrate";
    private double lowerAmountFactor = 1.5;
    private double upperAmountFactor = 2.0;
    private double lowerAmount;
    private double upperAmount;
    private String amount;
    private String energy = "4 kcal/g";

    public Carbohydrate(double weight) {
            lowerAmount = 2.2 * weight * lowerAmountFactor;
            upperAmount = 2.2 * weight * upperAmountFactor;
            this.amount = String.format("%.0f ~ %.0f g /day", lowerAmount, upperAmount);
    }

    public String getName() {
        return this.name;
    }

    public String getAmount() {
        return this.amount;
    }

    public String getEnergyPerGram() {
        return this.energy;
    }
}
