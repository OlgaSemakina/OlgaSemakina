package hw5.ex2;

import base.SelenideTestBaseHw4;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.hw5.DatesPage;
import pageObjects.hw5.HomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.Range2.FROM;
import static enums.Range2.TO;
import static enums.SitePages.HOME_PAGE;
import static enums.Users.PITER_CHAILOVSKII;

@Feature("Smoke tests")
@Story("Dates page testing")
@Listeners(AllureListener.class)
public class DatesPageSuite extends SelenideTestBaseHw4 {

    private HomePage homePage;
    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePage.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void datesPageSliders() {

        //1 Open test site by URL
        homePage.openPage();

        //2 Assert Browser title
        homePage.checkTitle(HOME_PAGE);

        //3 Perform login
        homePage.login(PITER_CHAILOVSKII);

        //4 Assert User name in the right-top side of screen that user is logged in
        homePage.checkUsername(PITER_CHAILOVSKII);

        //5 Open through the header menu Service -> Dates Page
        homePage.openDates();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most
        // right position
        datesPage.setSliders(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM, 0, TO, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most
        // left position.
        datesPage.setSliders(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM, 0, TO, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most
        // right position.
        datesPage.setSliders(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM, 100, TO, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.setSliders(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM, 30, TO, 70);
    }
}
