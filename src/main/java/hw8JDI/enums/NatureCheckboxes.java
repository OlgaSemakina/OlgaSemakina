package hw8JDI.enums;

public enum NatureCheckboxes {

    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire");

    public String name;

    NatureCheckboxes(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
