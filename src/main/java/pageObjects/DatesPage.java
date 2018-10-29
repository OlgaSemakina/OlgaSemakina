package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.or;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class DatesPage {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = ".dropdown")
    private SelenideElement service;

    @FindBy(css = ".dropdown [href='dates.html']")
    private SelenideElement dates;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection rangeSliders;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

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

    public void openDates() {
        service.click();
        dates.click();
    }

    public void setSliders(int fromPercent, int toPercent) {
        int width = slider.getSize().getWidth();
        int sliderWidth = rangeSliders.get(0).getSize().getWidth();

        int xSlider = slider.getLocation().getX();
        int xFrom = rangeSliders.get(0).getLocation().getX() + sliderWidth / 2;
        int xTo = rangeSliders.get(1).getLocation().getX() + sliderWidth / 2;

        int newXFrom = xSlider - xFrom + 1 + fromPercent * width / 100;
        int newXTo = xSlider - xTo + 1 + toPercent * width / 100;

        Actions action = new Actions(getWebDriver());
        if (newXTo <= xFrom) {
            action.moveToElement(slider)
                    .dragAndDropBy(rangeSliders.get(0), newXFrom, 0)
                    .dragAndDropBy(rangeSliders.get(1), newXTo, 0)
                    .perform();
        } else {
            action.moveToElement(slider)
                    .dragAndDropBy(rangeSliders.get(1), newXTo, 0)
                    .dragAndDropBy(rangeSliders.get(0), newXFrom, 0)
                    .perform();
        }
    }
    //================================checks===================================

    public void checkTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    public void checkUsername() {
        assertEquals(profileButton.getText(), "PITER CHAILOVSKII");
    }

    public void checkLogPercent(String left, int leftPercent, String right, int rightPercent) {
        ElementsCollection logsRange = logs.first(2);
        for (SelenideElement element : logsRange) {
            element.shouldHave(or("logs", matchText(".*" + right + ".." + rightPercent),
                    matchText(".*" + left + ".." + leftPercent)));
        }
    }
}
