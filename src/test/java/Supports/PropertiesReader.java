package Supports;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesReader {
    public static String browserRequired;
    public static String browserType;
    public static String browserHeadless;
    public static String webApplicationUrl;
    public static String applicationPassword;
    public static String applicationNewPassword;
    public static String applicationUsername;
    public static String applicationCreatedBy;
    public static String apiBaseURl;

    public void loadProperties() throws IOException {
        Properties settings = new Properties();
        settings.load(Files.newInputStream(Paths.get("config/settings.properties")));
        // get the property value and set it to a global variable
        browserRequired = settings.getProperty("browser.required");
        browserType = settings.getProperty("browser.type");
        browserHeadless = settings.getProperty("browser.headless");
        webApplicationUrl = settings.getProperty("application.url");
        applicationPassword = settings.getProperty("application.password");
        applicationNewPassword = settings.getProperty("application.newPassword");
        applicationUsername = settings.getProperty("application.username");
        applicationCreatedBy = settings.getProperty("application.createdBy");
        // api createTemplate.EndPoint
        apiBaseURl = settings.getProperty("api.baseURL");
    }

//    public String loadProperties(String key) {
//        Properties data = new Properties();
//        try {
//            data.load(new FileInputStream("data/commonData.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return data.getProperty(key);
//    }
}
