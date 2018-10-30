package enums;

public enum Radios {

    GOLD("Gold"), SILVER("Silver"), BRONZE("Bronze"), SELEN("Selen");

    public String name;
    public static int size = 4;

    Radios(String name) {
        this.name = name;
    }
}
