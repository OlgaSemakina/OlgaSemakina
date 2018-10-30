package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceElements {

    SUPPORT("Support"), DATES("Dates"), COMPLEX_TABLE("Complex Table"), SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table with pages"), DIFFERENT_ELEMENTS("Different elements");

    public String name;

    ServiceElements(String name) {
        this.name = name;
    }

    public static List<String> getServiceElements() {
        return new ArrayList<String>() {{
            add("Support");
            add("Dates");
            add("Complex Table");
            add("Simple Table");
            add("Table with pages");
            add("Different elements");
        }};
    }
}
