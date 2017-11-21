package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import driverFactory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import video.CucumberVideoRecorder;

/**
 * Created by osolomin on 16.11.17.
 */
public class Hooks {

    private CucumberVideoRecorder cucumberVireoRecorder = new CucumberVideoRecorder();

    @Before
    public void beforeScenario(){
        DriverFactory.startRemoteChrome();
//        java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        Dimension targetSize = new Dimension(screenSize.getWidth(), screenSize.getHeight());
//        DriverFactory.getInstance().manage().window().setSize(targetSize);
        DriverFactory.getInstance().manage().window().maximize();
    //    cucumberVireoRecorder.start();
    }

    @After
    public void afterScenario(Scenario scenario){
        try {
            if (scenario.isFailed()) {
                takeScreenshot();
            }
            DriverFactory.attachedVideo();
//            cucumberVireoRecorder.stopRecording(scenario.getName());
//            cucumberVireoRecorder.attachment();
        }finally {
            DriverFactory.closeBrowser();
        }
    }

    @Attachment(value = "Screenshot")
    private byte[] takeScreenshot() {
        return ((TakesScreenshot) DriverFactory.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
