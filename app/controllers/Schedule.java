package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.base_with_nav;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Schedule extends Controller {

    public static Result index() {
        return ok(base_with_nav.render());
    }

    public static Result workoutSchedule() {
        return ok(base_with_nav.render());
    }

    public static Result nutritionSchedule() {
        return ok(base_with_nav.render());
    }

}
