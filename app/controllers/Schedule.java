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
    private static ExerciseScheduleRule exSchRule = new ExerciseScheduleRule();
    private static NutritionRule nuRule = new NutritionRule();
    private static CardioRule caRule = new CardioRule();

    private static MeatRule meatRule = new MeatRule();
    private static VegetableRule vegetableRule = new VegetableRule();
    private static DrinkRule drinkRule = new DrinkRule();

    public static Result index() {
        return ok(select_schedule.render());
    }

    public static Result workoutSchedule() {
        User thisUser = User.findById(Long.parseLong(session("userId")));
        int userWorkoutDays = thisUser.getUserWorkoutDays();
        int age = thisUser.getAge();
        boolean workoutIsIntense = thisUser.isWorkoutIsIntense();
        boolean cardioIsIntense = thisUser.isCardioIsIntense();
        String gender = thisUser.getGender();
        exSchRule.setInput(userWorkoutDays, workoutIsIntense, gender );
        caRule.setInput(age, cardioIsIntense );
        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(exSchRule);
        rulesEngine.registerRule(caRule);
        rulesEngine.fireRules();
        List<Day> workoutScheduleList = exSchRule.getResult();
        List<Cardio> cardiotScheduleList = caRule.getResult();
        return ok(workout_schedule.render(workoutScheduleList, cardiotScheduleList, cardioIsIntense));
    }

    public static Result nutritionSchedule() {
        User thisUser = User.findById(Long.parseLong(session("userId")));
        double weight = thisUser.getWeight();
        boolean isGain = thisUser.isGain();
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

        return ok(nutrition_schedule.render(nuList,rawMaterialList));
    }

}
