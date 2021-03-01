package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.services.IUserAdminService;
import pl.edu.wszib.przesylki.session.SessionObject;

@Service
public class UserAdminServiceImpl implements IUserAdminService {

    @Autowired
    SessionObject sessionObject;

    @Override
    public boolean authenticate(UserAdmin userAdmin) {
        return false;
    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }
}
