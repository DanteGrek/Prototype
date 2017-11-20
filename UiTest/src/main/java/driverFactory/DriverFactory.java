package driverFactory;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testcontainers.containers.BrowserWebDriverContainer;

import java.io.File;

/**
 * Created by osolomin on 16.11.17.
 */
public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ThreadLocal<BrowserWebDriverContainer> browser = new ThreadLocal<>();

    public static WebDriver getInstance(){
        return driver.get();
    }

    public static void startChrome(){
        ChromeDriverManager.getInstance().setup();
        driver.set(new ChromeDriver());
    }

    public static void setupChromeContainer(){
        browser.set(new BrowserWebDriverContainer().withDesiredCapabilities(DesiredCapabilities.chrome())
                .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("/video/")));
    }

    public static void startRemoteChrome(){
        browser.get().start();
        driver.set(browser.get().getWebDriver());
    }

    public static void closeBrowser(){
        if(driver.get() != null) {
            driver.get().quit();
        }
    }

    public static void closeContainer(){
        browser.get().close();
    }
}
