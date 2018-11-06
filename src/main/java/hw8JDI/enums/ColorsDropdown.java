package hw8JDI.enums;

public enum ColorsDropdown {

    COLORS("Colors"), RED("Red"), GREEN("Green"), BLUE("Blue"), YELLOW("Yellow");

    public String name;

    ColorsDropdown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
