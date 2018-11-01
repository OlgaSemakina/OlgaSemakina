package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Range2;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertTrue;

public class DatesPage extends SiteBase {

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection rangeSliders;

    @FindBy(css = ".ui-slider")
    private SelenideElement slider;

    @FindBy(css = ".logs li")
    private ElementsCollection logs;

    //================================methods===================================

    public void setSliders(int fromPercent, int toPercent) {
        double width = slider.getSize().getWidth();
        double sliderWidth = rangeSliders.get(0).getSize().getWidth();

        double xSlider = slider.getLocation().getX();
        double xFrom = rangeSliders.get(0).getLocation().getX() + sliderWidth / 2;
        double xTo = rangeSliders.get(1).getLocation().getX() + sliderWidth / 2;

        double offsetXFrom = xSlider - xFrom + fromPercent * width / 100;
        double offsetXTo = xSlider - xTo + toPercent * width / 100;

        Actions action = new Actions(getWebDriver());
        if (xTo + offsetXTo <= xFrom) {
            action.moveToElement(slider)
                    .dragAndDropBy(rangeSliders.get(0), (int) Math.ceil(offsetXFrom), 0)
                    .dragAndDropBy(rangeSliders.get(1), (int) Math.ceil(offsetXTo), 0)
                    .perform();
        } else {
            action.moveToElement(slider)
                    .dragAndDropBy(rangeSliders.get(1), (int) Math.ceil(offsetXTo), 0)
                    .dragAndDropBy(rangeSliders.get(0), (int) Math.ceil(offsetXFrom), 0)
                    .perform();
        }
    }

    //================================checks===================================

    public void checkLogPercent(Range2 from, int fromPercent, Range2 to, int toPercent) {
        ElementsCollection logsRange = logs.first(2);
        String regexFrom = ".*" + from.name + ".." + fromPercent;
        String regexTo = ".*" + to.name + ".." + toPercent;
        assertTrue(checkLog(regexFrom, regexTo, logsRange) || checkLog(regexTo, regexFrom, logsRange));
    }

    private boolean checkLog(String regexFirst, String regexSecond, ElementsCollection logsRange) {
        return logsRange.get(0).has(matchText(regexFirst)) && logsRange.get(1).has(matchText(regexSecond));
    }
}
