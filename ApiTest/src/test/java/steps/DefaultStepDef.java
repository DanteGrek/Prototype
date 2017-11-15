package steps;

import api.ApiEngine;
import cucumber.api.Transpose;
import cucumber.api.java.en.Given;

import java.util.List;

/**
 * Created by osolomin on 15.11.17.
 */
public class DefaultStepDef extends ApiEngine {


    @Given("^(?:Do get to|Do get) '(.*)'")
    public void stepDoGet(String endpoint){
        doGet(endpoint);
    }

    @Given("^Do post to '(.*)' with body$")
    public void stepDoPost(String endpoint, @Transpose List<String> json){

    }
}
