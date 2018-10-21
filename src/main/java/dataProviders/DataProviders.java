package dataProviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviders {
    private List<String> neededTexts = new ArrayList<String>() {{
        add("To include good practices\nand ideas from successful\nEPAM project");
        add("To be flexible and\ncustomizable");
        add("To be multiplatform");
        add("Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    }};

    @DataProvider
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {"String1", 1},
                {"String2", 2},
                {"String3", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] iconTextsProvider() {
        return new Object[][]{
                {neededTexts, 0},
                {neededTexts, 1},
                {neededTexts, 2},
                {neededTexts, 3},
        };
    }
}
