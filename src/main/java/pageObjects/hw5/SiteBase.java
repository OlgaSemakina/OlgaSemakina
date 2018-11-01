package pageObjects.hw5;

import com.codeborne.selenide.SelenideElement;
import enums.SitePages;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

abstract class SiteBase {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    //================================checks===================================

    @Step
    public void checkTitle(SitePages page)  {
        assertEquals(getWebDriver().getTitle(), page.title);
    }

    @Step
    public void checkUsername(Users user) {
        profileButton.shouldHave(text(user.username));
    }

    @Step
    public void checkLeftSectionExists() {
        leftSection.shouldBe(visible);
    }
}
