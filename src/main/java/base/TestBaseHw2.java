package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

public class TestBaseHw2 {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }
}
