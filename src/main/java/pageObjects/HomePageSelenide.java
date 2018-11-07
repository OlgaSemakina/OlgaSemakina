package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class HomePageSelenide {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    //================================methods===================================

    public void openPage() {
        open("https://epam.github.io/JDI/index.html");
    }

    public void login(String name, String passwd){
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkMainText() {
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));
    }
}
