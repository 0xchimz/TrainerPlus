package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.nutrition_schedule;
import views.html.select_schedule;
import views.html.workout_schedule;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Schedule extends Controller {

    public static Result index() {
        return ok(select_schedule.render());
    }

    public static Result workoutSchedule() {
        return ok(workout_schedule.render());
    }

    public static Result nutritionSchedule() {
        return ok(nutrition_schedule.render());
    }

}
