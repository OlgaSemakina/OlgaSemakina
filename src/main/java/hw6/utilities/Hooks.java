package hw6.utilities;

import cucumber.api.java.After;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;

public class Hooks {
    @After
    public void afterScenario() {
        closeWebDriver();
    }
}
