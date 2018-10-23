package lesson4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.*;
import static enums.Users.PITER_CHAILOVSKII;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenidePageObject extends SelenideTestBase {

    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        //2 Navigate
        homePageSelenide.openPage();

        //3 Assert Title
        homePageSelenide.checkTitle();

        //4 Login
        homePageSelenide.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

//        $(".profile-photo").click();
//        $("[id = 'Name']").sendKeys("epam");
//        $("[id = 'Password']").sendKeys("1234");
//        $("[type = 'submit']").click();

        //5 Check main title
        homePageSelenide.checkMainText();

//        SelenideElement maintTitle = $("h3.main-title");
//        maintTitle.shouldBe(visible);
//        maintTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
//        assertEquals(maintTitle.getText(), "EPAM FRAMEWORK WISHES…");

    }
}
