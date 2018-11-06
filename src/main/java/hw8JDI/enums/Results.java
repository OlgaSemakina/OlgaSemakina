package hw8JDI.enums;

public enum Results {

    SUMMARY("Summary"), ELEMENTS("Elements"), COLOR("Color"), METAL("Metal"), VEGETABLES("Vegetables");

    public String name;

    Results(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
