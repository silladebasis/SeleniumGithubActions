package driver;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private static ThreadLocal<WebDriver> tDriver = new ThreadLocal<WebDriver>();
    static BrowserDriver browserDriver = null;
    static WebDriver driver ;
    private DriverFactory(){

    }
    public static WebDriver getDriver(String browserType) {
        switch (browserType){
            case "Chrome" -> browserDriver = new ChromeDriverManager();
            case "Firefox" -> browserDriver = new FirefoxDriverManager();
            case "Remote" -> browserDriver = new RemoteDriverManager();
            default -> throw new IllegalArgumentException("Unsupported browser Type: " + browserType);
        }
        driver = browserDriver.createDriver();
        tDriver.set(driver);
        return driver;
    }
    public static void quitDriver(){
        WebDriver driver = tDriver.get();
        if(driver!=null){
            driver.quit();
            tDriver.remove();
        }
    }

}
