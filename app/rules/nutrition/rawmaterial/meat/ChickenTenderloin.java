package rules.nutrition.rawmaterial.meat;

import rules.nutrition.rawmaterial.RawMaterial;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class ChickenTenderloin implements RawMaterial {
    private String type = "Meat";
    private String classification = "Chicken";
    private String name = "Chicken Tenderloin";
    private String amount = "100 g";
    private String protein = "23 g";

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getClassification() {
        return this.classification;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAmount() {
        return this.amount;
    }

    @Override
    public String getProtein() {
        return this.protein;
    }
}
