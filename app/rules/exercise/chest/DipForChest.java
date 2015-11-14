package rules.exercise.chest;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class DipForChest extends ChestExercise {

    private String bodyPart = "Chest";
    private String name = "Dip for Chest";
    private String sets = "4";
    private String reps = "until fail";

    public DipForChest() {
        this.setValue(name, sets, reps);
    }
}

