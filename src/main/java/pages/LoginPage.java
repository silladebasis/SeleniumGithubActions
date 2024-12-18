package pages;

import Base.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPage {
    private final By txtUserName = By.id("user-name");
    private final By txtPassword = By.id("password");
    private final By loginBtn = By.id("login-button");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage enterUserName(String userName){
        driver.findElement(txtUserName).clear();
        sendText(txtUserName,userName);
        return this;
    }
    public LoginPage enterPassword(String pass){
        driver.findElement(txtPassword).clear();
        sendText(txtPassword,pass);
        return this;
    }
    public LoginPage clickOnLogin(){
        clickOnElement(loginBtn);
        return this;
    }
}
