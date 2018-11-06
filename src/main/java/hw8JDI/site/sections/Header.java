package hw8JDI.site.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import hw8JDI.enums.HeaderMenu;
import hw8JDI.site.forms.LoginForm;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    public LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public Label profilePhoto;

    @FindBy(css = ".nav>li>a")
    public Menu<HeaderMenu> menu;

}
