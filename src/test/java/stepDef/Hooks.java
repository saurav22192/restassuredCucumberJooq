package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.Context;

public class Hooks {
    Context context;
    public Hooks(Context context)
    {
        this.context = context;
    }
//	@Before
//    public void beforeScenario(){
//        System.out.println("This will run before the Scenario");
//    }
//
	@After
    public void afterScenario(){
        context.tearDown();
    }
}