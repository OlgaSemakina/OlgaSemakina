package hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.Checkboxes;
import enums.Radios;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.page;
import static enums.Dropdown.category;
import static org.testng.Assert.assertTrue;

public class DifferentElementsPage {

    private int buttonsSize = 2;

    @FindBy(css = ".label-checkbox input")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio input")
    private ElementsCollection radios;

    @FindBy(css = "select")
    private SelenideElement dropdown;

    @FindBy(css = "[class='uui-button']")
    private ElementsCollection buttons;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = "[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    public DifferentElementsPage() {
        page(this);
    }

    //================================methods===================================

    @Step
    @When("I (.*) checkboxes:")
    public void selectCheckboxes(String isSelected, List<String> checkbox) {
        boolean state = "select".equals(isSelected);
        for (String element : checkbox) {
            selectCheckbox(state, element);
        }
    }

    @Step
    @When("I select (.*) radio")
    public void selectRadio(String radio) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(radio))
                element.click();
        }
    }

    @Step
    @When("I select (.*) in dropdown")
    public void selectInDropdown(String dropdownColor) {
        dropdown.selectOption(dropdownColor);
    }

    private void selectCheckbox(boolean state, String checkbox) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(checkbox))
                element.setSelected(state);
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

    private boolean logContainsRadio(String name, SelenideElement element) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + element.name() + ".*" + name))) {
                return true;
            }
        }
        return false;
    }

    private boolean logContainsDropdown(String dropdownColorName) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + category + ".*" + dropdown.getSelectedText())) &&
                    dropdownColorName.equals(dropdown.getSelectedText())) {
                return true;
            }
        }
        return false;
    }

    //================================checks===================================

    @Step
    @Then("Different elements page interface contains all needed elements")
    public void checkDiffElementsPageInterface() {
        checkboxes.shouldHaveSize(Checkboxes.size);
        for (SelenideElement element : checkboxes) {
            element.shouldHave(type("checkbox"));
        }
        radios.shouldHaveSize(Radios.size);
        for (SelenideElement element : radios) {
            element.shouldHave(type("radio"));
        }
        dropdown.shouldBe(visible);
        buttons.shouldHaveSize(buttonsSize);
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    @Step
    @And("There is Right Section")
    public void checkRightSectionExists() {
        rightSection.shouldBe(visible);
    }

    @Step
    @And("There is Left Section")
    public void checkLeftSectionExists() {
        leftSection.shouldBe(visible);
    }

    @Step
    @Then("There is a log row for:")
    public void checkLogCheckboxes(List<String> checkboxes) {
        for (String element : checkboxes) {
            checkLogCheckbox(element);
        }
    }

    @Step
    @Then("There is a log row for radio (.*)")
    public void checkLogRadios(String radioName) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(radioName))
                assertTrue(logContainsRadio(radioName, element));
        }
    }

    @Step
    @Then("There is a log row for dropdown (.*)")
    public void checkLogDropdown(String dropdownColor) {
        assertTrue(logContainsDropdown(dropdownColor));
    }

    private void checkLogCheckbox(String checkboxName) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(checkboxName))
                assertTrue(logContainsCheckbox(checkboxName, element));
        }
    }
}
