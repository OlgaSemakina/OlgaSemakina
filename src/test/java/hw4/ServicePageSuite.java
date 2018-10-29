package hw4;

import base.SelenideTestBaseHw4;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.ServicePage;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static enums.Dropdown.YELLOW;
import static enums.Radios.BRONZE;
import static enums.Users.PITER_CHAILOVSKII;
import static enums.Checkboxes.WIND;
import static enums.Checkboxes.WATER;

public class ServicePageSuite extends SelenideTestBaseHw4 {

    private ServicePage servicePage;

    private List<String> serviceElements = new ArrayList<String>() {{
        add("Support");
        add("Dates");
        add("Complex Table");
        add("Simple Table");
        add("Table with pages");
        add("Different elements");
    }};

    @BeforeClass
    public void beforeClass() {
        servicePage = page(ServicePage.class);
    }

    @Test
    public void servicePageInterfaceTest() {

        //1 Open test site by URL
        servicePage.openPage();

        //2 Assert Browser title
        servicePage.checkTitle();

        //3 Perform login
        servicePage.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4 Assert User name in the right-top side of screen that user is loggined
        servicePage.checkUsername(PITER_CHAILOVSKII.username);

        //5 Click on "Service" subcategory in the header and check that drop down contains options
        servicePage.checkServiceDropdownContains(serviceElements);

        //6 Click on Service subcategory in the left section and check that drop down contains options
        servicePage.checkServiceLeftDropdownContains(serviceElements);

        //7 Open through the header menu Service -> Different Elements Page
        servicePage.openDiffElements();

        //8 Check interface on Different elements page, it contains all needed elements
        servicePage.checkDiffElementsPageInteface();

        //9 Assert that there is Right Section
        servicePage.checkRightSectionExists();

        //10 Assert that there is Left Section
        servicePage.checkLeftSectionExists();

        //11 Select checkboxes
        servicePage.selectCheckbox(WATER.name, true);
        servicePage.selectCheckbox(WIND.name, true);

        //12 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        servicePage.checkLogCheckboxes(WIND.name);
        servicePage.checkLogCheckboxes(WATER.name);

        //13 Select radio
        servicePage.selectRadio(BRONZE.name);

        //14 Assert that for radiobutton there is a log row
        // and value is corresponded to the status of radiobutton. 
        servicePage.checkLogRadios(BRONZE.name);

        //15 Select in dropdown
        servicePage.selectInDropdown(YELLOW.name);

        //16 Assert that for dropdown there is a log row
        // and value is corresponded to the selected value. 
        servicePage.checkLogDropdown(YELLOW.category);

        //17 Unselect and assert checkboxes
        servicePage.selectCheckbox(WATER.name, false);
        servicePage.selectCheckbox(WIND.name, false);

        //18 Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        servicePage.checkLogCheckboxes(WIND.name);
        servicePage.checkLogCheckboxes(WATER.name);
    }
}
