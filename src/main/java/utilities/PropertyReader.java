package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static final String GRID_URL = "selenium.grid.url";
    protected static Properties properties;
    public static Properties readPropertiesFile() {
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/main/resources/configuration.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }
    public static String getProperty(String key){
        return readPropertiesFile().getProperty(key);
    }
}
