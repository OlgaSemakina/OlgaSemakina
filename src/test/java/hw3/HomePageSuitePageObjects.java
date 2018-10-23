package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageHw3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static enums.Users.PITER_CHAILOVSKII;

public class HomePageSuitePageObjects extends TestBase {

    private WebDriver driver;
    private HomePageHw3 homePage;

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

    private String mainText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT " +
            "LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO " +
            "LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN " +
            "VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";


    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        homePage = PageFactory.initElements(driver, HomePageHw3.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void homePageContentTest() {

        //1 Open test site by URL
        homePage.open(driver);

        //2 Assert Browser title
        homePage.checkTitle(driver);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the right-top side of screen that user is loggined
        homePage.checkUsername(PITER_CHAILOVSKII.username);

        //5 Assert Browser title
        homePage.checkTitle(driver);

        //6 Assert that there are 4 items on the header section are displayed and they have proper texts
        homePage.checkHeaderItems(neededItems);

        //7 Assert that there are 4 images on the Home Page and they are displayed
        homePage.checkIcons();

        //8 Assert that there are 4 texts on the Home Page under icons and they have proper text
        homePage.checkIconTexts(neededTexts);

        //9 Assert a text of the main header
        homePage.checkMainTitle();
        homePage.checkMainText(mainText);

        //10 Assert that there is the iframe in the center of page
        homePage.checkFrame();

        //11 Switch to the iframe and check that there is Epam logo in the left top corner of iframe
        homePage.openFrame(driver);
        homePage.checkLogo();

        //12 Switch to original window back
        homePage.openOriginalWindow(driver);

        //13 Assert a text of the sub header
        homePage.checkSubHeaderText();

        //14 Assert that JDI GITHUB is a link and has a proper URL
        homePage.checkSubHeaderLink();

        //15 Assert that there is Left Section
        homePage.checkLeftSection();

        //16 Assert that there is Footer
        homePage.checkFooter();

        //17 Close Browser
        driver.close();
    }
}
