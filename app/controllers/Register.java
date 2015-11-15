package controllers;

import java.util.*;

import models.User;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.regis;

import java.time.*;
import java.time.format.*;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("y-M-d", Locale.ENGLISH);
        LocalDate localDatedate = LocalDate.parse(birthdate, formatter);
        Date date = Date.from(localDatedate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        User newUser = User.create(email, password, date, gender);
        if(newUser != null) {
            session().clear();
            User currentUser = User.findByEmail(email);
            session("userId", String.valueOf(currentUser.getId()));
            flash("success", "Register successful.");
            return redirect(routes.Profile.index());
        } else {
            flash("error", "Register error.");
            return badRequest(regis.render());
        }
    }
}
