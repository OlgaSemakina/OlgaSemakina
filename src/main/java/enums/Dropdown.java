package enums;

public enum Dropdown {
    RED("Red", "Colors"), GREEN("Green", "Colors"),
    BLUE("Blue", "Colors"), YELLOW("Yellow", "Colors");

    public String name;
    public String category;

    Dropdown(String name, String category) {
        this.name = name;
        this.category = category;
    }
}
