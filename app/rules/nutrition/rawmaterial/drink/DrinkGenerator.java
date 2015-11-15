package rules.nutrition.rawmaterial.drink;

import rules.nutrition.rawmaterial.RawMaterial;
import rules.nutrition.rawmaterial.meat.*;

import java.util.ArrayList;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class DrinkGenerator {
    private ArrayList<RawMaterial> milk = new ArrayList<RawMaterial>();

    public DrinkGenerator() {
        addMilk();
    }

    private void addMilk() {
        this.milk.add(new Milk());

    }
    public ArrayList<RawMaterial> getMilk() {
        return this.milk;
    }

}
