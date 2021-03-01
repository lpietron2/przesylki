package pl.edu.wszib.przesylki.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.przesylki.dao.IHibernateUserAdminDAO;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;

@Repository
public class HibernateUserAdminDAOImpl implements IHibernateUserAdminDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserAdmin getUserAdminByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.przesylki.model.UserAdmin WHERE ")


        return null;
    }
}
