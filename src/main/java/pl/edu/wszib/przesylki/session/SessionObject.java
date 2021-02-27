package pl.edu.wszib.przesylki.session;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.model.UserAdmin;

@Component
@SessionScope
public class SessionObject {
    private String info = null;
    private UserAdmin loggedUser = null;

    public UserAdmin getLoggedUser(){
        return loggedUser;
    }

    public void setLoggedUser(UserAdmin loggedUser){
        this.loggedUser = loggedUser;
    }

    public boolean isLogged(){
        return this.loggedUser != null;
    }

    public void setInfo(String info){
        this.info = info;
    }

    public String getInfo(){
        String temp = this.info;
        this.info = null;
        return temp;
    }

}
