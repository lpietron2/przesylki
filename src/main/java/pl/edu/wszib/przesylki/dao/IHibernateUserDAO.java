package pl.edu.wszib.przesylki.dao;

import pl.edu.wszib.przesylki.model.User;

import java.util.List;

public interface IHibernateUserDAO {
    User getUserById(int id);
    User persistUser(User user);
    List<User> getUserByAddress(String address);
    List<User> getUserByName(String name, String lastName);

}
