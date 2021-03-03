package pl.edu.wszib.przesylki.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.model.User;

import javax.persistence.NoResultException;
import java.util.List;

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

    @Override
    public void persistUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(user);
            tx.commit();
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }

    @Override
    public List<User> getUserByAddress(String address) {
        Session session = this.sessionFactory.openSession();
        Query<User> query = session.createQuery("FROM pl.edu.wszib.przesylki.model.User WHERE address = :address");

        List<User> result = query.getResultList();

        session.close();
        return result;
    }
}
