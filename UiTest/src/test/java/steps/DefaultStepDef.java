package steps;

import cucumber.api.java.en.Given;
import driverFactory.DriverFactory;
import org.testng.Assert;

/**
 * Created by osolomin on 15.11.17.
 */
public class DefaultStepDef {

    @Given("^(?:Open|Start|Launch|Go to) (.*)")
    public void stepDoGet(String site){
        DriverFactory.getInstance().get(site);
        Assert.assertTrue(false);
    }

    @Given("^Background$")
    public void background(/*String endpoint, @Transpose List<String> json*/){
        System.out.println("Background !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
