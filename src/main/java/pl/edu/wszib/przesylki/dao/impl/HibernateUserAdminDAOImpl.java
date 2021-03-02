package pl.edu.wszib.przesylki.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.przesylki.dao.IHibernateUserAdminDAO;
import pl.edu.wszib.przesylki.model.UserAdmin;

import javax.persistence.NoResultException;

@Repository
public class HibernateUserAdminDAOImpl implements IHibernateUserAdminDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public UserAdmin getUserAdminByLogin(String login) {
        Session session = this.sessionFactory.openSession();
        Query<UserAdmin> query = session.createQuery("FROM pl.edu.wszib.przesylki.model.UserAdmin WHERE login = :login");
        query.setParameter("login", login);
        UserAdmin result = null;
        try{
            result = query.getSingleResult();
        }catch(NoResultException e){
            System.out.println("Nie znaleziono usera");
        }
        session.close();

        return result;
    }
}
