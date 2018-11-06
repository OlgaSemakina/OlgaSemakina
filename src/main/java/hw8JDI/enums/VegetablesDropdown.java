package hw8JDI.enums;

public enum VegetablesDropdown {

    CUCUMBER("Cucumber"), TOMATO("Tomato"), VEGETABLES("Vegetables"), ONION("Onion");

    public String name;

    VegetablesDropdown(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
