package rules.nutrition.rawmaterial.meat;

import rules.nutrition.rawmaterial.RawMaterial;

import java.util.ArrayList;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class MeatGenerator {
    private ArrayList<RawMaterial> chicken = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> pig = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> seafood = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> beef = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> wild = new ArrayList<RawMaterial>();
    private ArrayList<RawMaterial> all = new ArrayList<RawMaterial>();

    public MeatGenerator() {
        addChicken();
        addBeef();
        addPig();
        addSeafood();
        addWild();

        this.all.addAll(chicken);
        this.all.addAll(pig);
        this.all.addAll(seafood);
        this.all.addAll(beef);
        this.all.addAll(wild);
    }

    private void addChicken() {
        chicken.add(new ChickenBreast());
        chicken.add(new ChickenTenderloin());
    }

    private void addPig() {
        pig.add(new PigSirloin());
        pig.add(new PigTenderloin());
    }

    private void addSeafood() {
        seafood.add(new DollyFish());
        seafood.add(new Salmon());
        seafood.add(new Shrimp());
    }

    private void addBeef() {
        beef.add(new Beef());
        beef.add(new Lamb());
    }

    private void addWild() {
        wild.add(new BoarSirloin());
        wild.add(new BoarTenderloin());
    }

    public ArrayList<RawMaterial> getChicken() {
        return this.chicken;
    }

    public ArrayList<RawMaterial> getPig() {
        return this.pig;
    }

    public ArrayList<RawMaterial> getSeafood() {
        return this.seafood;
    }

    public ArrayList<RawMaterial> getBeef() {
        return this.beef;
    }

    public ArrayList<RawMaterial> getWild() {
        return this.wild;
    }

    public ArrayList<RawMaterial> getAll() {
        return this.all;
    }
}
