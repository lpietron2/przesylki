package pl.edu.wszib.przesylki.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.User;

import javax.persistence.NoResultException;

@Repository
public class HibernateUserDAOImpl implements IHibernateUserDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.przesylki.model.User WHERE id = :id");
        query.setParameter("id", id);
        User result = null;

        try{
            result = query.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Nie znaleziono usera");
        }

        session.close();

        return result;
    }
}
