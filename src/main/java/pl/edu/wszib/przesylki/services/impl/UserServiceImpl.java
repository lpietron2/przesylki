package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.services.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IHibernateUserDAO hibernateUserDAO;

    @Override
    public User getUserById(int id) {
        return this.hibernateUserDAO.getUserById(id);
    }
}
