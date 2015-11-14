package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.profile;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Profile extends Controller {

    public static Result index() {
        return ok(profile.render());
    }
}
