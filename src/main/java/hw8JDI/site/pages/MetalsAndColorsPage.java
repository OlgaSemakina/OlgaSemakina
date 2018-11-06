package hw8JDI.site.pages;


import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import hw8JDI.site.forms.MetalsAndColorsForm;
import hw8JDI.site.sections.ResultsSection;

@JPage(url = "/metals-color.html", title = "Metal and Colors")
public class MetalsAndColorsPage extends SiteBase {

    public MetalsAndColorsForm form;
    public ResultsSection results;
}
