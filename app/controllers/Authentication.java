package controllers;

import models.User;
import play.data.*;
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

    public static Result authenticate() {
        DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
        String username = dynamicForm.get("username");
        String password = dynamicForm.get("password");
        return ok();
    }

}
