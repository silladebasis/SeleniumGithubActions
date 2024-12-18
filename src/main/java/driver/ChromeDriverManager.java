package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserDriver{
    @Override
    public WebDriver createDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");  // Run in headless mode
        chromeOptions.addArguments("--disable-gpu");  // Disable GPU hardware acceleration
        chromeOptions.addArguments("--no-sandbox");
        return new ChromeDriver(chromeOptions);
    }
}
