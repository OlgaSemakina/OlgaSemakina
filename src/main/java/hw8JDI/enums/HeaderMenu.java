package hw8JDI.enums;

public enum HeaderMenu {
    HOME("Home"), CONTACT_FORM("Contact Form"), SERVICE("Service"), METALS_COLORS("Metals & Colors");

    private String name;

    HeaderMenu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name.toUpperCase();
    }
}
