package cucubmerrunner;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.CucumberFeatureWrapperImpl;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature;
import driverFactory.DriverFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by osolomin on 11.05.17.
 */
public class TestNgCucumberFeatureRunner{

    private TestNGCucumberRunner testNGCucumberRunner;
    private CucumberFeatureWrapper cucumberFeature;

    @BeforeClass(alwaysRun = true)
    public void startContainer(){
        DriverFactory.setupChromeContainer();
    }

    public TestNgCucumberFeatureRunner(CucumberFeature cucumberFeature2, Object runner) {
        testNGCucumberRunner = new TestNGCucumberRunner(runner.getClass());
        cucumberFeature = new CucumberFeatureWrapperImpl(cucumberFeature2);
    }

    @Test(groups = {"cucumber"})
    public void feature() {
        this.testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass(){
        DriverFactory.closeContainer();
        this.testNGCucumberRunner.finish();
    }
}
