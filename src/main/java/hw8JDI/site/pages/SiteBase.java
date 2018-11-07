package hw8JDI.site.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import hw8JDI.entities.User;
import hw8JDI.enums.Users;
import hw8JDI.site.sections.Header;

public abstract class SiteBase extends WebPage {

    public Header header;

    public void login(Users user) {
        header.profilePhoto.click();
        // TODO What the point of this TWO classes with exactly the same purpose ?
        header.loginForm.loginAs(new User(user));
    }
}
