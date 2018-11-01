package pageObjects.hw5;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static enums.SitePages.HOME_PAGE;
import static org.testng.Assert.assertTrue;

public class HomePage extends SiteBase {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "[class = 'dropdown']")
    private SelenideElement service;

    @FindBy(css = ".dropdown [href='dates.html']")
    private SelenideElement dates;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceMenu;

    @FindBy(css = "[class = 'sub'] a")
    private ElementsCollection serviceMenuLeft;

    @FindBy(css = "a[ui='label']")
    private SelenideElement serviceLeft;

    @FindBy(xpath = "//a[text()='Different elements']")
    private SelenideElement diffElements;

    //================================methods===================================

    @Step
    public void openPage() {
        open(HOME_PAGE.url);
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    public void openDates() {
        service.click();
        dates.click();
    }

    @Step
    public void openDiffElements() {
        service.click();
        diffElements.click();
    }

    //================================checks===================================

    @Step
    public void checkServiceDropdownContains(List<String> serviceElements) {
        service.click();
        for (String element : serviceElements) {
            assertTrue(serviceMenu.texts().contains(element.toUpperCase()));
        }
    }

    @Step
    public void checkServiceLeftDropdownContains(List<String> serviceElements) {
        serviceLeft.click();
        assertTrue(serviceMenuLeft.texts().containsAll(serviceElements));
    }
}
