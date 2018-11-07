package hw8JDI.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import hw8JDI.enums.Users;
import hw8JDI.site.sections.Header;

public abstract class SiteBase extends WebPage {

    public Header header;

    public void login(Users user) {
        header.profilePhoto.click();
        header.loginForm.loginAs(user);
    }
}
