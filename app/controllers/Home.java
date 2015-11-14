package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.home;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Home extends Controller {

    public static Result index() {
        return ok(home.render());
    }
}
