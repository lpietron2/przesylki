package pl.edu.wszib.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.IHibernatePackageDAO;

import java.util.List;

@Repository
public class HibernatePackageDAOImpl implements IHibernatePackageDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Package> getAllPackages() {
        Session session = this.sessionFactory.openSession();
        session.close();


        return null;
    }
}
