package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import tests.testUtils.CommandLineParameters;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private final static Logger logger = Logger.getLogger(BaseTest.class);
    protected static AppiumDriver driver;

    @BeforeClass(alwaysRun = true)
    public AppiumDriver setDriver() throws MalformedURLException {
        File appDirAndroid = new File("src/main/resources/app/");
        File appAndroid = new File(appDirAndroid, "Sminq.apk");

        if (System.getProperty(CommandLineParameters.PLATFORM_NAME).equalsIgnoreCase("android")) {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformVersion", System.getProperty(CommandLineParameters.PLATFORM_VERSION));
            capabilities.setCapability("app", appAndroid.getAbsolutePath());
            capabilities.setCapability("udid", System.getProperty(CommandLineParameters.UDID));
            capabilities.setCapability("platformName", System.getProperty(CommandLineParameters.PLATFORM_NAME));
            capabilities.setCapability("browserName", System.getProperty(CommandLineParameters.BROWSER));
            capabilities.setCapability("appPackage", System.getProperty(CommandLineParameters.APP_PACKAGE));
            capabilities.setCapability("appActivity", System.getProperty(CommandLineParameters.APP_ACTIVITY));
            capabilities.setCapability("newCommandTimeout", System.getProperty(CommandLineParameters.NEW_COMMAND_TIMEOUT));
            capabilities.setCapability("automationName", System.getProperty(CommandLineParameters.AUTOMATION_NAME));
            capabilities.setCapability("deviceName", System.getProperty(CommandLineParameters.DEVICE_NAME));
            capabilities.setCapability("platform", System.getProperty(CommandLineParameters.PLATFORM));
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
            return driver;
        } else if (System.getProperty(CommandLineParameters.PLATFORM).equalsIgnoreCase("ios")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformVersion", System.getProperty(CommandLineParameters.PLATFORM_VERSION));
            capabilities.setCapability("deviceName", System.getProperty(CommandLineParameters.DEVICE_NAME));
            capabilities.setCapability("browserName", System.getProperty(CommandLineParameters.BROWSER));
            //capabilities.setCapability("app", System.getProperty(CommandLineParameters.APP));
            capabilities.setCapability("bundleId", System.getProperty(CommandLineParameters.BUNDLE_ID));
            capabilities.setCapability("udid", System.getProperty(CommandLineParameters.UDID));
            capabilities.setCapability("platform", System.getProperty(CommandLineParameters.PLATFORM));
            capabilities.setCapability("platformName", MobilePlatform.IOS);
            capabilities.setCapability("showIOSLog", true);
            capabilities.setCapability("automationName", System.getProperty(CommandLineParameters.AUTOMATION_NAME));
            capabilities.setCapability("newCommandTimeout", 50000);
            // capabilities.setCapability("xcodeOrgId", System.getProperty(CommandLineParameters.XCODE_ORG_ID));
            // capabilities.setCapability("xcodeSigningId", System.getProperty(CommandLineParameters.XCODE_SIGNING_ID));
            capabilities.setCapability(IOSMobileCapabilityType.AUTO_ACCEPT_ALERTS, Boolean.TRUE);
            capabilities.setCapability("startIWDP", true);
//            capabilities.setCapability("useNewWDA", useNewWDA);
            capabilities.setCapability("usePrebuiltWDA", true);
            capabilities.setCapability("launchTimeout", "50000");
            capabilities.setCapability("wdaLaunchTimeout", "50000");
            capabilities.setCapability("wdaConnectionTimeout", "50000");
            capabilities.setCapability("wdaStartupRetries", "4");
            capabilities.setCapability("wdaStartupRetryInterval", "50000");
            capabilities.setCapability("autoAcceptAlerts", "true");
            capabilities.setCapability("unexpectedAlertBehaviour", "true");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            return driver;
        }
        return null;
    }
}
