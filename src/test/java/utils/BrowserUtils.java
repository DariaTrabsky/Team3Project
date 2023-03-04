package utils;

import org.openqa.selenium.WebDriver;

public class BrowserUtils {
    public static void switchToWindow(WebDriver driver) {
        for (String each : driver.getWindowHandles()) {
            if (!each.equalsIgnoreCase(driver.getWindowHandle())) {
                driver.switchTo().window(each);
            }
        }
    }
}
