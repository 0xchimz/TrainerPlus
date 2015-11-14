package rules.exercise;

import rules.exercise.abs.Crunch;
import rules.exercise.abs.ObliqueCrunch;
import rules.exercise.abs.StandingBarbellTwist;
import rules.exercise.chest.*;
import rules.exercise.back.*;
import rules.exercise.leg.*;
import rules.exercise.ham.*;
import rules.exercise.calf.*;
import rules.exercise.biceps.*;
import rules.exercise.shoulder.*;
import rules.exercise.trapz.*;
import rules.exercise.triceps.*;


import java.util.ArrayList;

/**
 * Created by Ong on 11/14/2015 AD.
 */
public class ExerciseGenerator {
    private ArrayList<Exercise> abs = new ArrayList<Exercise>();
    private ArrayList<Exercise> backs = new ArrayList<Exercise>();
    private ArrayList<Exercise> chests = new ArrayList<Exercise>();
    private ArrayList<Exercise> legs = new ArrayList<Exercise>();
    private ArrayList<Exercise> ham = new ArrayList<Exercise>();
    private ArrayList<Exercise> calf = new ArrayList<Exercise>();
    private ArrayList<Exercise> biceps = new ArrayList<Exercise>();
    private ArrayList<Exercise> triceps = new ArrayList<Exercise>();
    private ArrayList<Exercise> trapz = new ArrayList<Exercise>();
    private ArrayList<Exercise> shoulders = new ArrayList<Exercise>();

    public ExerciseGenerator() {
    }

    public void addChestExercise() {
        this.chests.add(new BarbellBenchPress());
        this.chests.add(new DipForChest());
        this.chests.add(new DumbbellFly());
        this.chests.add(new InclineDumbbellBenchPress());
    }

    public void addBackExercise() {
        this.backs.add(new BackExtension());
        this.backs.add(new BarbellDeadlift());
        this.backs.add(new BarbellRow());
        this.backs.add(new LatPullDown());
    }

    public void addAbsExercise() {
        this.abs.add(new Crunch());
        this.abs.add(new ObliqueCrunch());
        this.abs.add(new StandingBarbellTwist());
    }

    public void addLegExercise() {
        this.legs.add(new BarbellSquat());
        this.legs.add(new LegExtension());
        this.legs.add(new LegPress());
    }

    public void addHamExercise() {
        this.ham.add(new BarbellStiffLegDeadlift());
        this.ham.add(new SeatedLegCurl());
    }

    public void addCalfExercise() {
        this.calf.add(new BarbellStandingCalfRaise());
        this.calf.add(new SeatedCalfRaise());
    }

    public void addBicepsExercise() {
        this.biceps.add(new BarbellCurl());
        this.biceps.add(new PreacherCurl());
    }

    public void addTricpesExercise() {
        this.triceps.add(new TricepsExtension());
        this.triceps.add(new TricepsPushDown());
    }

    public void addTrapzExercise() {
        this.trapz.add(new BarbellShrug());
    }

    public void addShoulderExercise() {
        this.shoulders.add(new DumbbellShoulderPress());
        this.shoulders.add(new HighPull());
        this.shoulders.add(new ReverseFly());
        this.shoulders.add(new SideLateralRaise());
    }

    public void addAll (){
        this.addAbsExercise();
        this.addBackExercise();
        this.addBicepsExercise();
        this.addCalfExercise();
        this.addChestExercise();
        this.addHamExercise();
        this.addLegExercise();
        this.addShoulderExercise();
        this.addTrapzExercise();
        this.addTricpesExercise();
    }

    public ArrayList<Day> create5DaysExercise() {
        this.addAll();
        ArrayList<Day> days = new ArrayList<Day>();

        ArrayList<Exercise> day1 = new ArrayList<Exercise>(this.chests);
        day1.add(this.abs.get(0));

        ArrayList<Exercise> day2 = new ArrayList<Exercise>(this.backs);
        day2.addAll(this.trapz);

        ArrayList<Exercise> day3 = new ArrayList<Exercise>(this.legs);
        day3.addAll(this.ham);
        day3.addAll(this.calf);

        ArrayList<Exercise> day4 = new ArrayList<Exercise>(this.shoulders);
        day4.addAll(this.abs);
        day4.remove(this.abs.get(0));

        ArrayList<Exercise> day5 = new ArrayList<Exercise>(this.biceps);
        day5.addAll(this.triceps);


        days.add(new Day("1",day1));
        days.add(new Day("2",day2));
        days.add(new Day("3",day3));
        days.add(new Day("4",day4));
        days.add(new Day("5",day5));

        return days;
    }

    public ArrayList<Day> create4DaysExercise() {
        this.addAll();
        ArrayList<Day> days = new ArrayList<Day>();

        ArrayList<Exercise> day1 = new ArrayList<Exercise>(this.chests);
        day1.addAll(this.biceps);
        day1.add(this.abs.get(0));

        ArrayList<Exercise> day2 = new ArrayList<Exercise>(this.backs);
        day2.addAll(this.trapz);

        ArrayList<Exercise> day3 = new ArrayList<Exercise>(this.legs);
        day3.addAll(this.ham);
        day3.addAll(this.calf);

        ArrayList<Exercise> day4 = new ArrayList<Exercise>(this.shoulders);
        day4.addAll(this.abs);
        day4.remove(this.abs.get(0));
        day4.addAll(this.triceps);


        days.add(new Day("1",day1));
        days.add(new Day("2",day2));
        days.add(new Day("3",day3));
        days.add(new Day("4",day4));

        return days;
    }

    public ArrayList<Day> create3DaysExercise() {
        this.addAll();
        ArrayList<Day> days = new ArrayList<Day>();

        ArrayList<Exercise> day1 = new ArrayList<Exercise>(this.chests);
        day1.addAll(this.backs);
        day1.addAll(this.trapz);

        ArrayList<Exercise> day2 = new ArrayList<Exercise>(this.shoulders);
        day2.addAll(this.abs);
        day2.addAll(this.triceps);
        day2.addAll(this.biceps);

        ArrayList<Exercise> day3 = new ArrayList<Exercise>(this.legs);
        day3.addAll(this.ham);
        day3.addAll(this.calf);


        days.add(new Day("1",day1));
        days.add(new Day("2",day2));
        days.add(new Day("3",day3));

        return days;
    }

    public ArrayList<Day> create2DaysExercise() {
        this.addAll();
        ArrayList<Day> days = new ArrayList<Day>();

        ArrayList<Exercise> day1 = new ArrayList<Exercise>();
        day1.add(this.chests.get(0));
        day1.add(this.chests.get(1));
        day1.add(this.shoulders.get(0));
        day1.add(this.shoulders.get(1));
        day1.add(this.backs.get(0));
        day1.add(this.backs.get(1));
        day1.add(this.biceps.get(0));
        day1.add(this.triceps.get(0));
        day1.add(this.abs.get(0));
        day1.add(this.trapz.get(0));

        ArrayList<Exercise> day2 = new ArrayList<Exercise>(this.legs);
        day2.addAll(this.ham);
        day2.addAll(this.calf);


        days.add(new Day("1",day1));
        days.add(new Day("2",day2));

        return days;
    }
}
