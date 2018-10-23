package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
    private String texts = "To include good practices\nand ideas from successful\nEPAM project" +
            " To be flexible and\ncustomizable To be multiplatform Already have good base\n(about 20" +
            " internal and\nsome external projects),\nwish to get more…";

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
                {texts, 0},
                {texts, 1},
                {texts, 2},
                {texts, 3},
        };
    }
}
