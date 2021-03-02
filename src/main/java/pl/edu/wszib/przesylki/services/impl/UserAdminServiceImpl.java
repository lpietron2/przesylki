package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.dao.IHibernateUserAdminDAO;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.services.IUserAdminService;
import pl.edu.wszib.przesylki.session.SessionObject;

@Service
public class UserAdminServiceImpl implements IUserAdminService {

    @Autowired
    SessionObject sessionObject;

    @Autowired
    IHibernateUserAdminDAO hibernateUserAdminDAO;

    @Override
    public void authenticate(UserAdmin userAdmin) {
        UserAdmin userFromDB = this.hibernateUserAdminDAO.getUserAdminByLogin(userAdmin.getLogin());
        if(userFromDB == null){
            return;
        }

        if(userFromDB.getPass().equals(userAdmin.getPass())){
            this.sessionObject.setLoggedUser(userFromDB);
        }

    }

    @Override
    public void logout() {
        this.sessionObject.setLoggedUser(null);
    }
}
