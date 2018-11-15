package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

@CucumberOptions(features = "src/test/java/hw6/", glue = {"hw6/pageObjects","hw6/entities"})
public class CucumberTestngRunnerHw6 extends AbstractTestNGCucumberTests {

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        Configuration.browser = "chrome";
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        closeWebDriver();
    }
}