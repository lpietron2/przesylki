package pl.edu.wszib.przesylki.dao;

import pl.edu.wszib.przesylki.model.UserAdmin;

public interface IHibernateUserAdminDAO {
    UserAdmin getUserAdminByLogin(String login);
}
