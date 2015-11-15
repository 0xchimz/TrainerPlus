package controllers;

import models.User;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.home;
import views.html.profile_information;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Home extends Controller {

    public static Result index() {
        return ok(home.render());
    }
    public static Result editProfile(){
        return ok(profile_information.render());
    }

    public static Result mock() {
        User.create("chincub@gmail.com","015335510");
        return ok(home.render());
    }
}
