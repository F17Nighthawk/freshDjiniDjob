package org.drozd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class JobFilter {
    public static int checkJobsCreatedToday(WebDriver driver){
        List<WebElement> todayJobElements = driver.findElements(By.xpath("//*[contains(text(), '22 May')]"));
        return todayJobElements.size();
        }
    }
