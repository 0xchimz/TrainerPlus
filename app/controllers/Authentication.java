package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Authentication extends Controller {

    public static Result index() {
        return ok(login.render());
    }
}
