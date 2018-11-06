package hw8JDI.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw8JDI.enums.Radios;
import org.openqa.selenium.support.FindBy;

import static hw8JDI.enums.Radios.getValueOf;

public class Summary extends Section {

    @FindBy(css = "#odds-selector .radio")
    public RadioButtons<Radios> oddsSummary;

    @FindBy(css = "#even-selector .radio")
    public RadioButtons<Radios> evenSummary;

    public void setOddsSummary(int oddSummary) {
        this.oddsSummary.select(getValueOf(oddSummary));
    }

    public void setEvenSummary(int evenSummary) {
        this.evenSummary.select(getValueOf(evenSummary));
    }
}
