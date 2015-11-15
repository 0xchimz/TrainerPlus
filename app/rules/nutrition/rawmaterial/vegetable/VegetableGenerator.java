package rules.nutrition.rawmaterial.vegetable;

import rules.nutrition.rawmaterial.RawMaterial;
import rules.nutrition.rawmaterial.meat.*;

import java.util.ArrayList;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class VegetableGenerator {
    private ArrayList<RawMaterial> nut = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> egg = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> soy = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> all = new ArrayList<RawMaterial>();

    public VegetableGenerator() {
        addNut();
        addEgg();
        addSoy();

        this.all.addAll(nut);
        this.all.addAll(egg);
        this.all.addAll(soy);
    }

    private void addNut() {
        nut.add(new Almond());
        nut.add(new Peanut());
    }

    private void addSoy() {
        soy.add(new Tofu());
        soy.add(new SoyBean());
    }

    private void addEgg() {
        egg.add(new WhiteEgg());
        egg.add(new WholeEgg());
    }

    public ArrayList<RawMaterial> getNut() {
        return this.nut;
    }
    public ArrayList<RawMaterial> getEgg() {
        return this.egg;
    }
    public ArrayList<RawMaterial> getSoy() {
        return this.soy;
    }

    public ArrayList<RawMaterial> getAll() {
        return this.all;
    }
}
