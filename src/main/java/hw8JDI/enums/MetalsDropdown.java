package hw8JDI.enums;

public enum MetalsDropdown {

    METALS("Metals"), GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    public String name;

    MetalsDropdown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
