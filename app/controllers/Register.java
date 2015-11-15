package controllers;

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
//        String email = dynamicForm.get("email");
//        String password = dynamicForm.get("password");
//        String
    }
}
