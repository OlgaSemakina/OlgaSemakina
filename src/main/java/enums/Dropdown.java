package enums;

public enum Dropdown {

    RED("Red"), GREEN("Green"),
    BLUE("Blue"), YELLOW("Yellow");

    public String name;
    public static String category = "Colors";

    Dropdown(String name) {
        this.name = name;
    }
}
