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
    public void isUserInDB(User user) {
        List<User> userList = this.hibernateUserDAO.getUserByAddress(user.getAddress());
        if(userList == null){
            this.hibernateUserDAO.persistUser(user);
        }
        for(User currentUser : userList){
            if(currentUser.equals(user)){
            }
        }
        this.hibernateUserDAO.persistUser(user);
    }
}
