package test1;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

@Rule(name = "Workout Rule", description = "Workout Rule")
public class WorkOutRule {

    /**
     * The user input which represents the data that the rule will operate on.
     */
    private boolean isIntense;

    @Condition
    public boolean checkInput() {
        //The rule should be applied only if the user's response is yes (duke friend)
        return (isIntense == true | isIntense == false);
    }

    @Action(order = 1)
    public void disOrder() throws Exception {
        if (isIntense == false){
        	System.out.println("You need a low-intensity workout");
        }
    }
    
    @Action(order = 2)
    public void intense() throws Exception {
        if (isIntense == true){
        	System.out.println("you need High intensity workout");
        }
    }

    public void setInput(boolean isIntense) {
    	this.isIntense = isIntense;
    }

}
