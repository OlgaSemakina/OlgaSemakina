package hw8JDI.enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234");

    public String name;
    public String password;

    Users(String login, String password) {
        this.name = login;
        this.password = password;
    }
}
