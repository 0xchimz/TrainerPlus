package controllers;

import play.mvc.Controller;
import play.mvc.Result;
/**
 * Created by Frank on 11/15/2015 AD.
 */
public class Register extends Controller {

    public static Result register() {
        return ok(views.html.regis.render());
    }
}
