package enums;

public enum Checkboxes {

    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String name;
    public static int size = 4;
    public static boolean enable = true;
    public static boolean disable = true;

    Checkboxes(String name) {
        this.name = name;
    }
}
