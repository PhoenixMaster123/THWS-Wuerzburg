package Klausurvorberaitung.Twotter;

import java.io.Serializable;

public class User implements Serializable {
    private final String benutzername;
    private String password;

    public User(String benutzername, String password) {
        this.benutzername = benutzername;
        this.password = password;
    }
}
