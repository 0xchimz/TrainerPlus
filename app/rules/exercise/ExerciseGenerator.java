package rules.exercise;

import rules.exercise.abs.*;
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


    public void addChestExercise(boolean isIntense) {
        this.chests.add(new BarbellBenchPress());
        this.chests.add(new DipForChest());
        if(isIntense) {
            this.chests.add(new DumbbellFly());
            this.chests.add(new InclineDumbbellBenchPress());
        }
    }

    public void addBackExercise(boolean isIntense) {
        this.backs.add(new BackExtension());
        this.backs.add(new BarbellDeadlift());

        if(isIntense) {
            this.backs.add(new BarbellRow());
            this.backs.add(new LatPullDown());
        }
    }

    public void addAbsExercise(boolean isIntense) {
        this.abs.add(new Crunch());
        this.abs.add(new ObliqueCrunch());

        if(isIntense) {
            this.abs.add(new StandingBarbellTwist());
        }
    }

    public void addLegExercise(boolean isIntense) {
        this.legs.add(new BarbellSquat());

        if(isIntense) {
            this.legs.add(new LegExtension());
            this.legs.add(new LegPress());
        }
    }

    public void addHamExercise(boolean isIntense) {
        this.ham.add(new BarbellStiffLegDeadlift());

        if(isIntense) {
            this.ham.add(new SeatedLegCurl());
        }
    }

    public void addCalfExercise(boolean isIntense) {
        this.calf.add(new BarbellStandingCalfRaise());

        if(isIntense) {
            this.calf.add(new SeatedCalfRaise());
        }
    }

    public void addBicepsExercise(boolean isIntense) {
        this.biceps.add(new BarbellCurl());

        if(isIntense) {
            this.biceps.add(new PreacherCurl());
        }
    }

    public void addTricpesExercise(boolean isIntense) {
        this.triceps.add(new TricepsExtension());

        if(isIntense) {
            this.triceps.add(new TricepsPushDown());
        }
    }

    public void addTrapzExercise(boolean isIntense) {
        this.trapz.add(new BarbellShrug());
    }

    public void addShoulderExercise(boolean isIntense) {
        this.shoulders.add(new DumbbellShoulderPress());
        this.shoulders.add(new HighPull());

        if(isIntense) {
            this.shoulders.add(new ReverseFly());
            this.shoulders.add(new SideLateralRaise());
        }
    }

    public void addAll (boolean isIntense){

        this.addAbsExercise(isIntense);
        this.addBackExercise(isIntense);
        this.addBicepsExercise(isIntense);
        this.addCalfExercise(isIntense);
        this.addChestExercise(isIntense);
        this.addHamExercise(isIntense);
        this.addLegExercise(isIntense);
        this.addShoulderExercise(isIntense);
        this.addTrapzExercise(isIntense);
        this.addTricpesExercise(isIntense);
    }

    public ArrayList<Day> create5DaysExercise(boolean isIntense) {
        this.addAll(isIntense);
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

    public ArrayList<Day> create4DaysExercise(boolean isIntense) {
        this.addAll(isIntense);
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

    public ArrayList<Day> create3DaysExercise(boolean isIntense) {
        this.addAll(isIntense);
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

    public ArrayList<Day> create2DaysExercise(boolean isIntense) {
        this.addAll(isIntense);
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

    public ArrayList<Day> generate(int day, boolean isIntense) {
        if(day == 2) return create2DaysExercise(isIntense);
        else if(day == 3) return create3DaysExercise(isIntense);
        else if(day == 4) return create4DaysExercise(isIntense);
        else if(day == 5) return create5DaysExercise(isIntense);
        else return null;
    }

}
