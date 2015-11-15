package controllers;

import models.User;
import org.joda.time.*;
import org.joda.time.format.*;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.regis;

/**
 * Created by Frank on 11/15/2015 AD.
 */
public class Register extends Controller {

    public static Result register() {
        return ok(regis.render());
    }

    public static Result submit() {
        DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
        String email = dynamicForm.get("email");
        String password = dynamicForm.get("password");
        String birthdate = dynamicForm.get("birthday");
        String gender = dynamicForm.get("gender");
        org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("y-M-d");
        DateTime dt = formatter.parseDateTime(birthdate);
        User newUser = User.create(email, password, dt, gender);
        if(newUser != null) {
            session().clear();
            User currentUser = User.findByEmail(email);
            session("userId", String.valueOf(currentUser.getId()));
            flash("success", "Register successful. Please select your plan and input your information.");
            return redirect(routes.Profile.index());
        } else {
            flash("error", "Register error. Email is already taken!");
            return badRequest(regis.render());
        }
    }
}
