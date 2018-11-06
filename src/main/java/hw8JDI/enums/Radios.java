package hw8JDI.enums;

public enum Radios {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), FIFTH(5), SIXTH(6), SEVENTH(7), EIGTH(8);

    public int serialNumber;

    Radios(int num) {
        this.serialNumber = num;
    }

    @Override
    public String toString() {
        return String.valueOf(serialNumber);
    }

    public static Radios getValueOf(int serialNumber) {
        for (Radios element : Radios.values()) {
            if (serialNumber == element.serialNumber) {
                return element;
            }
        }
        return null;
    }
}
