package pages;

import io.appium.java_client.MobileElement;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.Yaml;
import utils.DriverHelper;

import java.util.Map;

public class LoginPage {
private static Logger logger = Logger.getLogger(LoginPage.class);

    private Map<String, String> loginPageLocators;
    Yaml yaml = null;

    public LoginPage() {
        this.yaml = new Yaml();
        this.loginPageLocators = (Map) yaml.load(getClass().getClassLoader().getResourceAsStream("locators/loginPage.yml"));
    }



}
