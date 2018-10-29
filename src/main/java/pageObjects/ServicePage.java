package pageObjects;

import com.codeborne.selenide.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ServicePage {

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

    @FindBy(css = "ul.dropdown-menu a")
    private ElementsCollection serviceMenu;

    @FindBy(xpath = "//a[text()='Different elements']")
    private SelenideElement diffElements;

    @FindBy(css = "a[ui='label']")
    private SelenideElement serviceLeft;

    @FindBy(css = "[class = 'sub'] a")
    private ElementsCollection serviceMenuLeft;

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


    //================================methods===================================


    public void openPage() {
        open("https://epam.github.io/JDI/");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void openDiffElements() {
        service.click();
        diffElements.click();
    }

    public void selectCheckbox(String name, boolean state) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(name))
                element.setSelected(state);
        }
    }

    public void selectRadio(String name) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(name))
                element.click();
        }
    }

    public void selectInDropdown(String name) {
        dropdown.selectOption(name);
    }

    private boolean logContainsCheckbox(String name, SelenideElement element) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + name + ".*" + element.isSelected()))) {
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

    private boolean logContainsDropdown(String category) {
        for (SelenideElement logElement : logs) {
            if (logElement.has(matchText(".*" + category + ".*" + dropdown.getSelectedText()))) {
                return true;
            }
        }
        return false;
    }

    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkUsername(String username) {
        profileButton.shouldHave(text(username));
    }

    public void checkServiceDropdownContains(List<String> serviceElements) {
        service.click();
        for (String element : serviceElements) {
            assertTrue(serviceMenu.texts().contains(element.toUpperCase()));
        }
    }

    public void checkServiceLeftDropdownContains(List<String> serviceElements) {
        serviceLeft.click();
        assertTrue(serviceMenuLeft.texts().containsAll(serviceElements));
    }


    public void checkDiffElementsPageInteface() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement element : checkboxes) {
            element.shouldHave(type("checkbox"));
        }
        radios.shouldHaveSize(4);
        for (SelenideElement element : radios) {
            element.shouldHave(type("radio"));
        }
        dropdown.shouldBe(visible);
        buttons.shouldHaveSize(2);
        for (SelenideElement element : buttons) {
            element.shouldBe(visible);
        }
    }

    public void checkRightSectionExists() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSectionExists() {
        leftSection.shouldBe(visible);
    }

    public void checkLogCheckboxes(String name) {
        for (SelenideElement element : checkboxes) {
            if (element.parent().getText().equals(name))
                assertTrue(logContainsCheckbox(name, element));
        }
    }

    public void checkLogRadios(String name) {
        for (SelenideElement element : radios) {
            if (element.parent().getText().equals(name))
                assertTrue(logContainsRadio(name, element));
        }
    }

    public void checkLogDropdown(String category) {
        assertTrue(logContainsDropdown(category));
    }

}
