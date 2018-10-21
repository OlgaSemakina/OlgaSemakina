package enums;

public enum Users {

    PITER_CHALOVSKII("epam", "1234");

    Users(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String login;
    public String password;
}
