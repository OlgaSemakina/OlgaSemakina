package pageObjects.hw4;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.Range2;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.or;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

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
        double xTo =  rangeSliders.get(1).getLocation().getX() + sliderWidth / 2;

        double newXFrom = xSlider - xFrom + fromPercent * width / 100;
        double newXTo = xSlider - xTo + toPercent * width / 100;

        Actions action = new Actions(getWebDriver());
        if (newXTo <= xFrom) {
            action.moveToElement(slider)
                    .dragAndDropBy(rangeSliders.get(0), (int)Math.ceil(newXFrom), 0)
                    .dragAndDropBy(rangeSliders.get(1), (int)Math.ceil(newXTo), 0)
                    .perform();
        } else {
            action.moveToElement(slider)
                    .dragAndDropBy(rangeSliders.get(1), (int)Math.ceil(newXTo), 0)
                    .dragAndDropBy(rangeSliders.get(0), (int)Math.ceil(newXFrom), 0)
                    .perform();
        }
    }

    //================================checks===================================

    public void checkLogPercent(Range2 from, int leftPercent, Range2 to, int rightPercent) {
        ElementsCollection logsRange = logs.first(2);
        for (SelenideElement element : logsRange) {
            element.shouldHave(or("logs", matchText(".*" + to.name + ".." + rightPercent),
                    matchText(".*" + from.name + ".." + leftPercent)));
        }
    }
}
