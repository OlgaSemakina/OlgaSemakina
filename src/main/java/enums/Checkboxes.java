package enums;

public enum Checkboxes {

    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String name;
    public static int size = 4;

    Checkboxes(String name) {
        this.name = name;
    }
}
