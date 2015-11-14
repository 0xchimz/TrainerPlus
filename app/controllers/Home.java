package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.base_with_nav;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Home extends Controller {

    public static Result index() {
        return ok(base_with_nav.render());
    }
}
