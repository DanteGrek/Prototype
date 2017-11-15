package steps;

import api.ApiEngine;
import cucumber.api.java.en.Given;

/**
 * Created by osolomin on 15.11.17.
 */
public class DefaultStepDef extends ApiEngine {

    @Given("^Do get to '(.*)'")
    public void step(String endpoint){
        doGet(endpoint);
    }
}
