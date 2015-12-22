package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import java.util.*;

import rules.nutrition.rawmaterial.RawMaterial;
import rules.nutrition.rawmaterial.meat.MeatGenerator;
import rules.nutrition.rawmaterial.vegetable.VegetableGenerator;
import views.html.nutrition_schedule;
import views.html.select_schedule;
import views.html.workout_schedule;
import org.easyrules.api.RulesEngine;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;
import rules.exercise.Day;
import rules.nutrition.*;
import rules.cardio.*;
import rules.*;
import models.*;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Schedule extends Controller {

    public static Result index() {
        return ok(select_schedule.render());
    }

    public static Result workoutSchedule() {
        ExerciseScheduleRule exSchRule = new ExerciseScheduleRule();
        CardioRule caRule = new CardioRule();
        User thisUser = User.findById(Long.parseLong(session("userId")));
        int userWorkoutDays = thisUser.getUserWorkoutDays();
        int age = thisUser.getAge();
        boolean workoutIsIntense = thisUser.isWorkoutIsIntense();
        boolean cardioIsIntense = thisUser.isCardioIsIntense();
        String gender = thisUser.getGender();
        if(userWorkoutDays == 0) {
            flash("error", "Please setting your plan.");
            return redirect(routes.Profile.index());
        }
        exSchRule.setInput(userWorkoutDays, false, gender);
        caRule.setInput(age, false);
        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(exSchRule);
        rulesEngine.registerRule(caRule);
        rulesEngine.fireRules();
        List<Day> workoutScheduleList = exSchRule.getResult();
        List<Cardio> cardiotScheduleList = caRule.getResult();

        exSchRule.setInput(userWorkoutDays, true, gender);
        caRule.setInput(age, true);
        rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(exSchRule);
        rulesEngine.registerRule(caRule);
        rulesEngine.fireRules();
        List<Day> workoutScheduleIntenseList = exSchRule.getResult();
        List<Cardio> cardiotScheduleIntenseList = caRule.getResult();

        return ok(workout_schedule.render(workoutScheduleList, cardiotScheduleList, cardioIsIntense,workoutScheduleIntenseList, cardiotScheduleIntenseList, thisUser.isGain()));
    }

    public static Result nutritionSchedule() {
        TDEERule tdeeRule = new TDEERule();
        CalEatingRule calEatingRule = new CalEatingRule();
        NutritionRule nuRule = new NutritionRule();
        MeatRule meatRule = new MeatRule();
        VegetableRule vegetableRule = new VegetableRule();
        DrinkRule drinkRule = new DrinkRule();

        User thisUser = User.findById(Long.parseLong(session("userId")));
        double weight = thisUser.getWeight();
        boolean isGain = thisUser.isGain();
        double height = thisUser.getHeight();
        if(weight == 0 || height == 0) {
            flash("error", "Please fill your information.");
            return redirect(routes.Profile.index());
        }
        nuRule.setInput(weight,isGain);
        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(nuRule);

        meatRule.setInput(true);
        vegetableRule.setInput(true);
        drinkRule.setInput(true);
        rulesEngine.registerRule(meatRule);
        rulesEngine.registerRule(vegetableRule);
        rulesEngine.registerRule(drinkRule);

        rulesEngine.fireRules();

        List<Nutrition> nuList = nuRule.getResult();

        List<RawMaterial> meatList = meatRule.getResult().getAll();
        List<RawMaterial> vetList = vegetableRule.getResult().getAll();
        List<RawMaterial> drinkList = drinkRule.getResult().getAll();

        List<RawMaterial> rawMaterialList = new ArrayList<RawMaterial>(meatList);
        rawMaterialList.addAll(vetList);
        rawMaterialList.addAll(drinkList);

        List<String> tdees = new ArrayList<String>();
        List<String> eatingCals = new ArrayList<String>();
        RulesEngine rulesEngine_tdee = aNewRulesEngine().withSilentMode(true).build();
        RulesEngine rulesEngine_cal = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine_tdee.registerRule(tdeeRule);
        rulesEngine_cal.registerRule(calEatingRule);
        for(int i=0; i < 5; i++) {
            tdeeRule.setInput(weight, height, thisUser.getGender(), thisUser.getAge(), 1.2 + (i * 0.2));
            rulesEngine_tdee.fireRules();
            tdees.add(tdeeRule.getResult());
            calEatingRule.setInput(Double.parseDouble(tdees.get(i)), isGain);

            rulesEngine_cal.fireRules();
            eatingCals.add(calEatingRule.getResult());
        }
        return ok(nutrition_schedule.render(nuList,rawMaterialList, tdees, eatingCals));
    }

}
