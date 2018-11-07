package hw8JDI;

import hw8JDI.base.TestBase;
import hw8JDI.dataProviders.DataProviders;
import hw8JDI.entities.MetalColorsData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static hw8JDI.enums.HeaderMenu.METALS_COLORS;
import static hw8JDI.enums.Users.PITER_CHAILOVSKII;
import static hw8JDI.site.JDISite.homePage;
import static hw8JDI.site.JDISite.metalsAndColorsPage;

public class MetalsColorsPageSuite extends TestBase {

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        homePage.clearCache();
    }


    @Test(dataProvider = "metalsColorsDataProvider", dataProviderClass = DataProviders.class)
    public void MetalsAndColorsFormTest(MetalColorsData data) {

        //1 Login on JDI site as User
        homePage.open();
        homePage.login(PITER_CHAILOVSKII);
        homePage.checkOpened();

        //2 Open Metals & Colors page by Header menu
        homePage.header.menu.select(METALS_COLORS);

        //3 Fill form Metals & Colors by data from DataProvider and submit
        metalsAndColorsPage.form.submitForm(data);

        //4 Result sections contains data from DataProvider:
        metalsAndColorsPage.results.check(data);
    }
}

