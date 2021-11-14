package com.OpenPayd.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class BrowserUtils {

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);
    }



}
