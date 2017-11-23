package driverFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

/**
 * Created by osolomin on 16.11.17.
 */
public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<BrowserWebDriverContainer> container = new ThreadLocal<>();

    public static WebDriver getInstance(){
        return driver.get();
    }

    public static void setupChromeContainer(){
        container.set(new BrowserWebDriverContainer().withDesiredCapabilities(DesiredCapabilities.chrome())
                /*.withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("/build/"))*/);
    }

    public static void startLocalChrome(){
        ChromeDriverManager.getInstance().setup();
        driver.set(new ChromeDriver());
    }

    public static void startRemoteChrome(){
        container.get().getContainerInfo();
        container.get().start();
        driver.set(container.get().getWebDriver());
    }

    public static void closeBrowser(){
        if(driver.get() != null) {
            driver.get().quit();
        }
    }

    public static void closeContainer(){
        container.get().close();
    }

    public static void attachedVideo(){
        try {
            container.get().attachment();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
