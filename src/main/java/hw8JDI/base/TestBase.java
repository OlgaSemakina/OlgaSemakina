package hw8JDI.base;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import hw8JDI.site.JDISite;
import org.testng.annotations.BeforeSuite;

public class TestBase extends TestNGBase {
    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebSite.init(JDISite.class);
    }
}
