package rules.nutrition;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class Protein implements Nutrition {

    private String name = "Protein";
    private double lowerAmountFactor = 1.0;
    private double upperAmountFactor = 1.5;
    private double normalAmountFactor = 0.8;
    private double normalAmount;
    private double lowerAmount;
    private double upperAmount;
    private String amount;
    private String energy = "4 kcal/g";

    public Protein(double weight, boolean isGainMuscle) {
        if(isGainMuscle) {
            lowerAmount = 2.2 * weight * lowerAmountFactor;
            upperAmount = 2.2 * weight * upperAmountFactor;
            this.amount = String.format("%.0f ~ %.0f g /day", lowerAmount, upperAmount);
        }
        else {
            normalAmount = 2.2 * weight * normalAmountFactor;
            this.amount = String.format("%.0f g /day", normalAmount);
        }
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
