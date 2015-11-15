package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.profile;
import play.data.*;
import models.User;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Profile extends Controller {

    public static Result index() {
        User thisUser = User.findById(Long.parseLong(session("userId")));
        return ok(profile.render(thisUser));
    }

    public static Result editProfile(){
      DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
      User thisUser = User.findById(Long.parseLong(session("userId")));
      thisUser.setHeight(Double.parseDouble(dynamicForm.get("inputheight")));
      thisUser.setWeight(Double.parseDouble(dynamicForm.get("inputweight")));
      thisUser.setWaistline(Double.parseDouble(dynamicForm.get("inputwaistline")));
      thisUser.setHip(Double.parseDouble(dynamicForm.get("inputhip")));
      boolean isGain = true;
      if(dynamicForm.get("inputgoal").equalsIgnoreCase("1")){
        isGain = true;
      }else{
        isGain = false;
      }
      thisUser.setIsGain(isGain);
        thisUser.setUserWorkoutDays(Integer.parseInt(dynamicForm.get("workoutDays")));
      thisUser.update();
      return ok(profile.render(thisUser));

    }
}
