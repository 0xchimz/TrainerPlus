package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.profile;
import play.data.*;
import models.*;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Profile extends Controller {

    public static Result index() {
        return ok(profile.render());
    }

    public static Result editProfile(){
      DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
      User thisUser = User.findById(Long.parseLong(session("userId")));
      thisUser.setHeight(Double.parseDouble(dynamicForm.get("input_height")));
      thisUser.setWeight(Double.parseDouble(dynamicForm.get("input_weight")));
      thisUser.setWaistline(Double.parseDouble(dynamicForm.get("input_waistline")));
      thisUser.setHip(Double.parseDouble(dynamicForm.get("input_hip")));
      thisUser.setIsGain(Boolean.parseBoolean(dynamicForm.get("input_goal")));
      thisUser.update();
      return ok(profile.render());

    }
}
