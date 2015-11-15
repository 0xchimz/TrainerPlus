package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import java.util.*;
import views.html.nutrition_schedule;
import views.html.select_schedule;
import views.html.workout_schedule;
import org.easyrules.api.RulesEngine;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;
import rules.exercise.Day;
import rules.nutrition.*;
import rules.cardio.*;
import rules.*;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Schedule extends Controller {
    private static ExerciseScheduleRule exSchRule = new ExerciseScheduleRule();
    private static NutritionRule nuRule = new NutritionRule();
    private static CardioRule caRule = new CardioRule();
    public static Result index() {
        return ok(select_schedule.render());
    }

    public static Result workoutSchedule() {
        int userWorkoutDays = 3;
        int age = 20;
        boolean workoutIsIntense = true;
        boolean cardioIsIntense = false;
        String gender = "male";
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
        double weight = 80;
        boolean isGain = false;
        nuRule.setInput(weight,isGain);
        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(nuRule);
        rulesEngine.fireRules();
        List<Nutrition> nuList = nuRule.getResult();

        return ok(nutrition_schedule.render(nuList));
    }

}
