package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Checkboxes;
import enums.Dropdown;
import enums.Radios;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static org.testng.Assert.assertTrue;
import static enums.Dropdown.category;

public class DifferentElementsPage extends SiteBase {

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

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    //================================methods===================================

    public void selectCheckboxes(boolean state, Checkboxes... checkbox) {
        for (Checkboxes element : checkbox) {
            selectCheckbox(state, element);
        }
    }

    public void selectCheckbox(boolean state, Checkboxes checkbox) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(checkbox.name))
                element.setSelected(state);
        }
    }

    public void selectRadio(Radios radio) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(radio.name))
                element.click();
        }
    }

    public void selectInDropdown(Dropdown dropdownColor) {
        dropdown.selectOption(dropdownColor.name);
    }

    private boolean logContainsCheckbox(Checkboxes checkbox, SelenideElement element) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + checkbox.name + ".*" + element.isSelected()))) {
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

    private boolean logContainsDropdown(Dropdown dropdownColor) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + category + ".*" + dropdown.getSelectedText())) &&
                    dropdownColor.name.equals(dropdown.getSelectedText())) {
                return true;
            }
        }
        return false;
    }

    //================================checks===================================

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

    public void checkRightSectionExists() {
        rightSection.shouldBe(visible);
    }

    public void checkLogCheckboxes(Checkboxes... checkboxes) {
        for (Checkboxes element : checkboxes) {
            checkLogCheckbox(element);
        }
    }

    public void checkLogRadios(Radios radio) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(radio.name))
                assertTrue(logContainsRadio(radio.name, element));
        }
    }

    public void checkLogDropdown(Dropdown dropdownColor) {
        assertTrue(logContainsDropdown(dropdownColor));
    }

    private void checkLogCheckbox(Checkboxes checkbox) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(checkbox.name))
                assertTrue(logContainsCheckbox(checkbox, element));
        }
    }
}
