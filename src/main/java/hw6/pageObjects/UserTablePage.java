package hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hw6.entities.UserFromTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class UserTablePage {

    @FindBy(xpath = "//td[1]")
    private ElementsCollection numbers;

    @FindBy(css = "#user-table select")
    private ElementsCollection numberTypeDropdowns;

    @FindBy(css = "#user-table a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table img")
    private ElementsCollection descriptionImages;

    @FindBy(css = "#user-table span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "#user-table input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    private int previousUser;

    public UserTablePage() {
        page(this);
    }

    //================================methods===================================

    @Step
    @When("I (.*) 'vip' checkbox for \"(.*)\"")
    public void selectCheckbox(String isSelected, String checkbox) {
        boolean state = "select".equals(isSelected);
        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkbox.equals(userNames.get(i).text())) {
                checkboxes.get(i).setSelected(state);
                break;
            }
        }
    }

    @Step
    @When("I click on dropdown in column Type for user (.*)")
    public void dropdownClick(String name) {
        for (int i = 0; i < numberTypeDropdowns.size(); i++) {
            if (name.equals(userNames.get(i).text())) {
                numberTypeDropdowns.get(i).click();
                previousUser = i;
                break;
            }
        }
    }

    private boolean logContainsCheckbox(String checkboxName, SelenideElement element) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + checkboxName + ".*" + element.isSelected()))) {
                return true;
            }
        }
        return false;
    }
    //================================checks===================================

    @Step
    @Then("\"(.*)\" page is opened")
    public void checkTitle(String page) {
        assertEquals(getWebDriver().getTitle(), page);
    }

    @Step
    @And("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkNumberTypeAmount(int number) {
        numberTypeDropdowns.shouldHaveSize(number);
    }

    @Step
    @And("(\\d+) User names are displayed on Users Table on User Table Page")
    public void checkUserNamesAmount(int number) {
        userNames.shouldHaveSize(number);
    }

    @Step
    @And("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void checkDescriptionImagesAmount(int number) {
        descriptionImages.shouldHaveSize(number);
    }

    @Step
    @And("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionTextsAmount(int number) {
        descriptionTexts.shouldHaveSize(number);
    }

    @Step
    @And("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxesAmount(int number) {
        checkboxes.shouldHaveSize(number);
    }

    @Step
    @And("User table contains following values:")
    public void checkUserTableContains(List<UserFromTable> table) {
        for (int i = 0; i < table.size(); i++) {
            UserFromTable user = table.get(i);
            assertEquals(Integer.parseInt(numbers.get(i).innerText()), user.getNumber());
            assertEquals(userNames.get(i).innerText(), user.getUser());
            assertEquals(descriptionTexts.get(i).innerText(), user.getDescription());
        }
    }

    @Step
    @Then("1 log row has \"(.*): condition changed to true\" text in log section")
    public void checkLogCheckbox(String checkboxName) {
        for (int i = 0; i < checkboxes.size(); i++) {
            if (checkboxName.equals(userNames.get(i).text())) {
                assertTrue(logContainsCheckbox(checkboxName, checkboxes.get(i)));
            }
        }
    }

    @Step
    @Then("droplist contains values")
    public void checkDroplistContains(List<String> dropdown) {
        assertTrue(numberTypeDropdowns.get(previousUser).innerText().replaceAll("\\s+", "")
                .matches(dropdown.get(1) + dropdown.get(2) + dropdown.get(3)));
    }
}
