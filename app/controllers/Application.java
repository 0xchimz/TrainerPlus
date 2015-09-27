package controllers;

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
        ObesityRule obesityRule = new ObesityRule();
        obesityRule.setInput("male", 1.5);

        RulesEngine rulesEngine = aNewRulesEngine().withSilentMode(true).build();
        rulesEngine.registerRule(obesityRule);
        rulesEngine.fireRules();

        String result = obesityRule.getResult();
        return ok(index.render(result));
    }
}
