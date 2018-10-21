package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageSuiteRegAndSmoke {

    private List<String> neededItems = new ArrayList<String>() {{
        add("HOME");
        add("CONTACT FORM");
        add("SERVICE");
        add("METALS & COLORS");
    }};

    private List<String> neededTexts = new ArrayList<String>() {{
        add("To include good practices\nand ideas from successful\nEPAM project");
        add("To be flexible and\ncustomizable");
        add("To be multiplatform");
        add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    }};

    @Test(groups = {"Smoke", "Regression"})
    public void homePageContentTest1() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //0 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the right-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationItems = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(navigationItems.size(), 4);

        for (WebElement element : navigationItems) {
            assertTrue(element.isDisplayed());
            assertTrue(neededItems.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(icons.size(), 4);

        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(iconTexts.size(), 4);

        for (WebElement element : iconTexts) {
            assertTrue(element.isDisplayed());
            assertTrue(neededTexts.contains(element.getText()));
        }

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement headerText = driver.findElement(By.cssSelector(".main-txt"));
        assertTrue(headerText.isDisplayed());
        assertEquals(headerText.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                        "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                        "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                        "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.tagName("iframe"));
        assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top corner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3 > a"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void homePageContentTest2() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //0 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the right-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationItems = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(navigationItems.size(), 4);

        for (WebElement element : navigationItems) {
            assertTrue(element.isDisplayed());
            assertTrue(neededItems.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(icons.size(), 4);

        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(iconTexts.size(), 4);

        for (WebElement element : iconTexts) {
            assertTrue(element.isDisplayed());
            assertTrue(neededTexts.contains(element.getText()));
        }

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement headerText = driver.findElement(By.cssSelector(".main-txt"));
        assertTrue(headerText.isDisplayed());
        assertEquals(headerText.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                        "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                        "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                        "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.tagName("iframe"));
        assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top corner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3 > a"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }

    @Test(groups = {"Smoke", "Regression"})
    public void homePageContentTest3() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //0 Open BR
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3 Perform login
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        driver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        driver.findElement(By.cssSelector(".login [type = 'submit']")).click();

        //4 Assert User name in the right-top side of screen that user is loggined
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo"));
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        //5 Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navigationItems = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(navigationItems.size(), 4);

        for (WebElement element : navigationItems) {
            assertTrue(element.isDisplayed());
            assertTrue(neededItems.contains(element.getText()));
        }

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> icons = driver.findElements(By.cssSelector(".benefit-icon"));
        assertEquals(icons.size(), 4);

        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page under icons and they have proper text
        List<WebElement> iconTexts = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(iconTexts.size(), 4);

        for (WebElement element : iconTexts) {
            assertTrue(element.isDisplayed());
            assertTrue(neededTexts.contains(element.getText()));
        }

        //9 Assert a text of the main header
        WebElement mainTitle = driver.findElement(By.cssSelector("h3.main-title"));
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");

        WebElement headerText = driver.findElement(By.cssSelector(".main-txt"));
        assertTrue(headerText.isDisplayed());
        assertEquals(headerText.getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
                        "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
                        "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
                        "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10 Assert that there is the iframe in the center of page
        WebElement frame = driver.findElement(By.tagName("iframe"));
        assertTrue(frame.isDisplayed());

        //11 Switch to the iframe and check that there is Epam logo in the left top corner of iframe
        driver.switchTo().frame("iframe");
        WebElement epamLogo = driver.findElement(By.id("epam_logo"));
        assertTrue(epamLogo.isDisplayed());

        //12 Switch to original window back
        driver.switchTo().defaultContent();

        //13 Assert a text of the sub header
        WebElement subHeader = driver.findElement(By.cssSelector("h3 > a"));
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");

        //14 Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");

        //15 Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSection.isDisplayed());

        //16 Assert that there is Footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        assertTrue(footer.isDisplayed());

        //17 Close Browser
        driver.close();
    }
}
