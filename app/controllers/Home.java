package controllers;

import models.User;
import models.WeightHistory;
import org.easyrules.api.RulesEngine;
import play.mvc.Controller;
import play.mvc.Result;
import rules.ObesityRule;
import views.html.home;
import views.html.regis;

import java.util.List;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

/**
 * Created by Frank on 11/14/2015 AD.
 */
public class Home extends Controller {

    public static Result index() {
        String result = null;
        List<WeightHistory> weightHistory = null;
//        System.out.println(User.findById(Long.parseLong(session("userId"))));
        if(session("userId") != null){
            User thisUser = User.findById(Long.parseLong(session("userId")));
            double weight = thisUser.getWeight();
            boolean isGain = thisUser.isGain();
            double height = thisUser.getHeight();
            if(weight == 0 || height == 0) {
                flash("error", "Please fill your information.");
                return redirect(routes.Profile.index());
            }
            ObesityRule obesityRule = new ObesityRule();
            RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
            rulesEngine.registerRule(obesityRule);
            obesityRule.setInput(thisUser.getGender(), thisUser.getWaistline() / thisUser.getHip());
            rulesEngine.fireRules();
            result = obesityRule.getResult();

            weightHistory =  WeightHistory.findByUser(thisUser);
        }

        return ok(home.render(result, weightHistory));
    }
    public static Result mock() {
//        User.create("chincub@gmail.com","015335510");
        return ok(home.render(null, null));
    }

    public static Result register(){
        return ok(regis.render());
    }
}
