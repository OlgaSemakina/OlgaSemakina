package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AllureListener extends TestListenerAdapter {

    @Attachment(value = "Attachment: {0}", type = "image/png")
    private byte[] makeScreenshot() {
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception ignored) {}
        return new byte[1];
    }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
    }
}
