package rules.nutrition.rawmaterial.vegetable;

import rules.nutrition.rawmaterial.RawMaterial;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class WholeEgg implements RawMaterial {
    private String type = "Vegetable";
    private String classification = "Egg";
    private String name = "Whole Egg";
    private String amount = "1 ea";
    private String protein = "8 g";

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
