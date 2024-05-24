package org.drozd;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class PageAction {
    public static void openMainPage(WebDriver driver, String url) {
        driver.get(url);
        try {
            driver.findElement(By.linkText("Sign In"));
            System.out.println("Сайт доступен, продолжай");
        } catch (NoSuchElementException e) {
            System.out.println("Страница недоступна");
            driver.quit();
        }
    }
}
