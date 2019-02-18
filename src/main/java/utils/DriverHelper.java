package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class DriverHelper {
    private static Logger logger = Logger.getLogger(DriverHelper.class);

    // Added a private constructor to hide the implicit public one.
    private DriverHelper(){

    }

    /**
     * Written generic method to find elements by xpath, id, name, classname, tagname, css-selector etc.
     *
     * @param locator representing locator type and locator value of element
     * @param driver  is used for automation
     * @return MobileElement of locator
     */

    public static MobileElement getMobileElement(String locator, AndroidDriver driver){
        MobileElement mobileElement;
        String locatorType = locator.split("_TBR_")[0].toLowerCase();
        String locatorValue = locator.split("_TBR_")[1];

        switch (locator){
            case "id":
                mobileElement = (MobileElement)(driver.findElement(By.id(locatorValue)));
                break;
            case "name":
                mobileElement = (MobileElement) (driver.findElement(By.name(locatorValue)));
                break;
            case "classname":
                mobileElement = (MobileElement) (driver.findElement(By.className(locatorValue)));
                break;
            case "tagname":
                mobileElement = (MobileElement) (driver.findElement(By.tagName(locatorValue)));
                break;
            case "cssselector":
                mobileElement = (MobileElement) (driver.findElement(By.cssSelector(locatorValue)));
                break;
            case "linktext":
                mobileElement = (MobileElement) (driver.findElement(By.linkText(locatorValue)));
                break;
            case "partiallinktext":
                mobileElement = (MobileElement) (driver.findElement(By.partialLinkText(locatorValue)));
                break;
            case "xpath":
                mobileElement = (MobileElement) (driver.findElement(By.xpath(locatorValue)));
                break;
            default:
                throw new IllegalArgumentException("Wrong locator type" + locatorType);
        }
        logger.info("Successfully getWebElement executed ");
        return mobileElement;
    }

}
