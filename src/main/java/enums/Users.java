package enums;

public enum Users {

    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    public String username;
    public String login;
    public String password;

    Users(String username, String login, String password) {
        this.username = username;
        this.login = login;
        this.password = password;
    }

    public static Users getValueOf(String username) {
        for (Users element : Users.values()) {
            if (username.equals(element.username)) {
                return element;
            }
        }
        return null;
    }
}
