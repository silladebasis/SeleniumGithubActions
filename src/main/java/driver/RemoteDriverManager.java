package driver;

import Constants.AppConstants;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteDriverManager implements BrowserDriver{
    private static final String HUB_URL = "http://localhost:4444/";
    Capabilities capabilities;
    @Override
    public WebDriver createDriver() {
       capabilities = new FirefoxOptions();
        try {
            return new RemoteWebDriver(new URL(HUB_URL),capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
