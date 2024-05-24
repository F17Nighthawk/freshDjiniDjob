package org.drozd;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    // Объявление глобальных переменных
    private static WebDriver driver;
    private static WebElement login;
    private static WebElement inputLogin;
    public static String url = "https://djinni.co/hire";
    public static String email = "khgymot991@vigoneo.com";
    public static String Password = "Nighthok1154";

    public static void main(String[] args) {
        // Инициализация WebDriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();

        PageAction.openMainPage(driver, url);
        clickSignIn();
        enterLoginPassword();
        ClickJobs();

        int NumberOfDjobs = JobFilter.checkJobsCreatedToday(driver);
        System.out.println("Количетсво новых вакансий: " + NumberOfDjobs);

        waitForSomeTime(4000);

        // Закрыть браузер
        driver.quit();
    }


    // Метод для нажатия кнопки Sign In
    private static void clickSignIn() {
        login = driver.findElement(By.linkText("Sign In"));
        login.click();
    }

    // Метод для ввода данных логина и нажатия клавиши Enter
    private static void enterLoginPassword() {
        inputLogin = driver.findElement(By.id("email"));
        inputLogin.sendKeys(email);
        inputLogin = driver.findElement(By.id("password"));
        inputLogin.sendKeys(Password);
        inputLogin.sendKeys(Keys.ENTER);
    }
// Метод перехода на страницу вакансий
    private static void ClickJobs(){
        WebElement click = driver.findElement(By.linkText("Jobs"));
        click.click();
    }

    // Метод для ожидания заданного времени
    private static void waitForSomeTime(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}