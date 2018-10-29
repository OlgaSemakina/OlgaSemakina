package hw4;

import base.SelenideTestBaseHw4;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DatesPage;


import static com.codeborne.selenide.Selenide.page;
import static enums.Range2.FROM;
import static enums.Range2.TO;
import static enums.Users.PITER_CHAILOVSKII;

public class DatesPageSuite extends SelenideTestBaseHw4 {

    private DatesPage datesPage;

    @BeforeClass
    public void beforeClass() {
        datesPage = page(DatesPage.class);
    }

    @Test
    public void datesPageSliders() {

        //1 Open test site by URL
        datesPage.openPage();

        //2 Assert Browser title
        datesPage.checkTitle();

        //3 Perform login
        datesPage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the right-top side of screen that user is loggined
        datesPage.checkUsername();

        //5 Open through the header menu Service -> Dates Page
        datesPage.openDates();

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most rigth position
        datesPage.setSliders(0, 100);

        //7 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM.name, 0, TO.name, 100);

        //8 Using drag-and-drop set Range sliders. left sliders - the most left position,
        // right slider - the most left position.
        datesPage.setSliders(0, 0);

        //9 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM.name, 0, TO.name, 0);

        //10 Using drag-and-drop set Range sliders. left sliders - the most rigth position,
        // right slider - the most rigth position.
        datesPage.setSliders(100, 100);

        //11 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM.name, 100, TO.name, 100);

        //12 Using drag-and-drop set Range sliders.
        datesPage.setSliders(30, 70);

        //13 Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogPercent(FROM.name, 30, TO.name, 70);

    }
}
