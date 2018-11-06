package hw8JDI.entities;

import hw8JDI.enums.Users;

public class User {
    public String name;
    public String password;

    public User(Users user) {
        this.name = user.login;
        this.password = user.password;
    }
}