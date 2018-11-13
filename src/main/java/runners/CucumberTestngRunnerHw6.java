package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(features = "src/test/java/hw6/", glue = {"hw6/pageObjects","hw6/utilities"})
public class CucumberTestngRunnerHw6 extends AbstractTestNGCucumberTests {

    @BeforeMethod
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}