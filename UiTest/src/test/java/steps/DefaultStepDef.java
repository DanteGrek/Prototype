package steps;

import cucumber.api.Transpose;
import cucumber.api.java.en.Given;

import java.util.List;

/**
 * Created by osolomin on 15.11.17.
 */
public class DefaultStepDef {


    @Given("^(?:Do get to|Do get) '(.*)'")
    public void stepDoGet(String endpoint){

    }

    @Given("^Do post to '(.*)' with body$")
    public void stepDoPost(String endpoint, @Transpose List<String> json){

    }
}
