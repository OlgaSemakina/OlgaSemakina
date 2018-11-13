package hw6.entities;

public class UserFromTable {
    private int number;
    private String user;
    private String description;

    public int getNumber() {
        return number;
    }

    public String getUser() {
        return user;
    }

    public String getDescription() {
        return description;
    }

    public UserFromTable(int number, String user, String description) {
        this.number = number;
        this.user = user;
        this.description = description;
    }
}
