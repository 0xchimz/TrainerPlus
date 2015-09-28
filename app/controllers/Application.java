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
    public static Result index() {
        return ok(index.render(""));
    }

    public static Result submit() {
        DynamicForm dynamicForm = new DynamicForm().bindFromRequest();
        String gender = dynamicForm.get("gender");
        String wph = dynamicForm.get("waistPerHip");
        double waistPerHip = Double.parseDouble(wph);
        ObesityRule obesityRule = new ObesityRule();
        obesityRule.setInput(gender, waistPerHip);

        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(obesityRule);
        rulesEngine.fireRules();

        String show = obesityRule.getResult();
        return ok(resultPage.render(show));
    }
}
