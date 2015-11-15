package controllers;

import models.User;
import play.Logger;
import play.data.*;
import play.mvc.Controller;
import play.mvc.Result;
import util.Authenticator;
import views.html.*;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Authentication extends Controller {

    public static Result login() {
        return ok(login.render(""));
    }

    public static Result authenticate() {
        if(session("userId") != null)
            return redirect(routes.Home.index());
        DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
        String email = dynamicForm.get("email");
        String password = dynamicForm.get("password");
        User user = Authenticator.getInstance().authenticate(email,password);
        if (user == null) {
            Logger.error("Login failed : cannot found user.");
            flash("error", "Username and password are incorrect.");
            return badRequest(login.render(email));
        }
        Logger.info("["+email+"] login success.");
        session().clear();
        User currentUser = User.findByEmail(email);
        session("userId", String.valueOf(currentUser.getId()));
        return redirect(routes.Home.index());
    }

    public static Result logout(){
        session().clear();
        return redirect(routes.Home.index());
    }

    public static User getCurrentUser(Long id){
        User tmp = User.findById(id);
        return tmp;
    }
}
