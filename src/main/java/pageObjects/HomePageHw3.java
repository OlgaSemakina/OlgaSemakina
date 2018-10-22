package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageHw3 {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = ".nav > li")
    private List<WebElement> navigationItems;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(css = "h3.main-title")
    private WebElement mainTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    @FindBy(css = "iframe")
    private WebElement frame;

    @FindBy(css = "#epam_logo")
    private WebElement logo;

    @FindBy(css = "h3 > a")
    private WebElement subHeader;

    @FindBy(css = "[name='navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "footer")
    private WebElement footer;

    //================================methods===================================

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void open(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/");
    }

    public void openFrame(WebDriver driver) {
        driver.switchTo().frame("iframe");
    }

    public void openOriginalWindow(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //================================checks===================================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUsername() {
        assertEquals(profileButton.getText(), "PITER CHAILOVSKII");
    }

    public void checkHeaderItems(List<String> neededItems) {
        assertEquals(navigationItems.size(), 4);
        for (WebElement element : navigationItems) {
            assertTrue(element.isDisplayed());
            assertTrue(neededItems.contains(element.getText()));
        }
    }

    public void checkIcons() {
        assertEquals(icons.size(), 4);
        for (WebElement element : icons) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkIconTexts(List<String> neededTexts) {
        assertEquals(iconTexts.size(), 4);
        for (WebElement element : iconTexts) {
            assertTrue(element.isDisplayed());
            assertTrue(neededTexts.contains(element.getText()));
        }
    }

    public void checkMainTitle() {
        assertTrue(mainTitle.isDisplayed());
        assertEquals(mainTitle.getText(), "EPAM FRAMEWORK WISHES…");
    }

    public void checkMainText(String text) {
        assertTrue(mainText.isDisplayed());
        assertEquals(mainText.getText(), text);
    }

    public void checkFrame() {
        assertTrue(frame.isDisplayed());
    }

    public void checkLogo() {
        assertTrue(logo.isDisplayed());
    }

    public void checkSubHeaderText() {
        assertTrue(subHeader.isDisplayed());
        assertEquals(subHeader.getText(), "JDI GITHUB");
    }

    public void checkSubHeaderLink() {
        assertEquals(subHeader.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }
}
