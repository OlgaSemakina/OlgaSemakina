package hw2.ex1;

import base.TestBase;
import dataProviders.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSuite extends TestBase {
    @Test(dataProvider = "iconTextsProvider", dataProviderClass = DataProviders.class)
    public void HomePageIconsTest(List<String> texts, int i) {

        // 1 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //2 Navigate
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //8 Assert that there are 4 texts on the Home Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(iconTexts.size(), 4);
        assertTrue(texts.contains(iconTexts.get(i).getText()));

        //5 Close BR
        driver.close();
    }
}
