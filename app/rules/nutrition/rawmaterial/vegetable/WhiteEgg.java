package rules.nutrition.rawmaterial.vegetable;

import rules.nutrition.rawmaterial.RawMaterial;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class WhiteEgg implements RawMaterial {
    private String type = "Vegetable";
    private String classification = "Egg";
    private String name = "White Egg (only Albumen)";
    private String amount = "1 ea";
    private String protein = "3 g";

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
