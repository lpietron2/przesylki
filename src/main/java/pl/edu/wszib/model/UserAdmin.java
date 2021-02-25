package pl.edu.wszib.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tuseradmin")
public class UserAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String login;
    String pass;

    public UserAdmin(int id, String login, String pass) {
        this.id = id;
        this.login = login;
        this.pass = pass;
    }

    public UserAdmin() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
