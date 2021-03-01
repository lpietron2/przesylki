package pl.edu.wszib.przesylki.dao;

import pl.edu.wszib.przesylki.model.User;

public interface IHibernateUserDAO {
    User getUserById(int id);
}
