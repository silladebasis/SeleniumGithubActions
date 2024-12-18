package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;

import java.io.IOException;
import java.util.Base64;


public class Utility {
    public static String getScreenshot(String imageName, WebDriver driver){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String filePath = "src/test/java/screenshots/"+imageName;
        try {
            FileHandler.copy(file,new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filePath;
    }
    public static String Base64Image(String screenshotPath) {
        byte[] file;
        try {
            file = FileUtils.readFileToByteArray(new File(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return Base64.getEncoder().encodeToString(file);
    }
}
