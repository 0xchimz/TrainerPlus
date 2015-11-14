package controllers;

import play.data.*;
import play.mvc.*;
import rules.*;
import views.html.*;
import org.easyrules.api.RulesEngine;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;


/**
 * Created by Chin on 9/27/2015.
 */
public class Application extends Controller {

    private static ObesityRule obesityRule = new ObesityRule();
    private static MuscularRule muscularRule = new MuscularRule();


    public static Result index() {
        return ok(index.render(""));
    }

    public static Result submit() {
        DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
        String gender = dynamicForm.get("gender");
        String wph = dynamicForm.get("waistPerHip");
        double waistPerHip = Double.parseDouble(wph);

        obesityRule.setInput(gender, waistPerHip);
        muscularRule.setInput(true, false);

        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(obesityRule);
        rulesEngine.registerRule(muscularRule);
        rulesEngine.fireRules();

        String show = obesityRule.getResult() + "\n" + muscularRule.getResult();
        return ok(resultPage.render(show));
    }
}
