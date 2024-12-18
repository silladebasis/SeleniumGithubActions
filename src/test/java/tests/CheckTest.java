package tests;

import BaseTest.TestBase;
import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CheckTest extends TestBase{
    @Test
    public void testCheckChrome(){
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Contact us")).click();
        System.out.println(driver.getTitle());
    }
    @Test
    public void testCheckFirefox(){
        driver.get("http://www.automationpractice.pl/index.php");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Contact us")).click();
        System.out.println(driver.getTitle());
    }
}
