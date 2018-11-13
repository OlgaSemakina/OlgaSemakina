package hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.HeaderMenu;
import enums.ServiceElements;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.textsInAnyOrder;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.SitePages.HOME_PAGE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {

    private int iconsSize = 4;
    private int iconTextsSize = 4;

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection iconTexts;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".nav>li")
    private ElementsCollection header;

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceMenu;

    @FindBy(css = "a[ui='label']")
    private SelenideElement serviceLeft;

    @FindBy(css = "[class = 'sub'] a")
    private ElementsCollection serviceMenuLeft;

    public HomePage() {
        page(this);
    }

    //================================methods===================================

    @Step
    @Given("I am on \"Home Page\"")
    public void openPage() {
        open(HOME_PAGE.url);
    }

    @Step
    @When("I login as user \"(.+)\" with password \"(.+)\"$")
    public void login(String userLogin, String userPassword) {
        profileButton.click();
        login.sendKeys(userLogin);
        password.sendKeys(userPassword);
        submit.click();
    }

    @Step
    @When("I login as user \"(\\S+ \\S+)\"$")
    public void loginByUser(String username) {
        Users user = Users.getValueOf(username.toUpperCase());
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

    @Step
    @Given("I am on the Different Elements page")
    public void openDiffElements() {
        headerClick(HeaderMenu.SERVICE.name());
        openPageFromService(ServiceElements.DIFFERENT_ELEMENTS.name);
    }

    @Step
    @When("I click on \"(.*)\" button in Header")
    public void headerClick(String name) {
        for (SelenideElement element : header) {
            if (element.text().equals(name.toUpperCase())) {
                element.click();
                break;
            }
        }
    }

    @Step
    @And("I click on \"(.*)\" button in Service dropdown")
    public void openPageFromService(String name) {
        for (SelenideElement element : serviceMenu) {
            if (element.text().equals(name.toUpperCase())) {
                element.click();
                break;
            }
        }
    }

    //================================checks===================================

    @Step
    @Then("The browser title is \"(.+ .+)\"")
    public void checkTitle(String page) {
        assertEquals(getWebDriver().getTitle(), page);
    }

    @Step
    @Then("The username (.+ .+) is displayed in the right-top side of the screen")
    public void checkUsername(String username) {
        profileButton.shouldHave(text(username));
    }

    @Step
    @And("Home page interface contains all needed elements")
    public void checkHomePageInterface() {
        icons.shouldHaveSize(iconsSize);
        iconTexts.shouldHaveSize(iconTextsSize);
        mainTitle.shouldBe(visible);
        mainText.shouldBe(visible);
    }

    @Step
    @And("Service dropdown contains options:")
    public void checkServiceDropdownContains(List<String> serviceElements) {
        headerClick(HeaderMenu.SERVICE.name());
        for (String element : serviceElements) {
            assertTrue(serviceMenu.texts().contains(element.toUpperCase()));
        }
    }

    @Step
    @And("Service dropdown in left section contains options:")
    public void checkServiceLeftDropdownContains(List<String> serviceElements) {
        serviceLeft.click();
        serviceMenuLeft.shouldHave(textsInAnyOrder(serviceElements));
    }
}
