import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.util.List;

public class News {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Укажите путь к вашему драйверу ChromeDriver
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testGetTechnologyNews() {
        // 1- Заходит на сайт https://www.reuters.com/
        driver.get("https://www.reuters.com/");

        // 2- Переход кликом в раздел /technology
        WebElement technologyLink = driver.findElement(By.linkText("Technology"));
        Assert.assertNotNull(technologyLink, "Technology link not found");
        technologyLink.click();

        // 3- Берет все новости за сегодняшний день
        // Предполагаем, что новости сегодняшнего дня имеют какой-то определённый класс или атрибут
        List<WebElement> newsHeadlines = driver.findElements(By.cssSelector("article[class*='story']"));
        Assert.assertFalse(newsHeadlines.isEmpty(), "No news found");

        // 4- Создаёт список и выводит его на экран
        System.out.println("Today's Technology News:");
        for (WebElement headline : newsHeadlines) {
            System.out.println(headline.getText());
        }
    }

    @AfterClass
    public void tearDown() {
        // 5- Закрывает браузер
        if (driver != null) {
            driver.quit();
        }
    }
}
