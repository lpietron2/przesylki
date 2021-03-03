package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.services.IUserService;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IHibernateUserDAO hibernateUserDAO;

    @Override
    public User getUserById(int id) {
        return this.hibernateUserDAO.getUserById(id);
    }

    @Override
    public void addNewUser(User user) {
        this.hibernateUserDAO.persistUser(user);
    }

    @Override
    public boolean isUserInDB(User user) {
        List<User> userList = this.hibernateUserDAO.getUserByAddress(user.getAdress());
        if(userList == null){
            this.hibernateUserDAO.persistUser(user);
            return false;
        }
        for(User currentUser : userList){
            if(currentUser.equals(user)){
                return true;
            }
        }
        this.hibernateUserDAO.persistUser(user);
        return false;
    }
}
