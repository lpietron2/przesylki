package pl.edu.wszib.przesylki.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.model.Package;

import javax.persistence.NoResultException;
import java.util.List;

@Repository
public class HibernatePackageDAOImpl implements IHibernatePackageDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public List<Package> getAllPackages() {
        Session session = this.sessionFactory.openSession();
        Query<Package> query = session.createQuery("FROM pl.edu.wszib.przesylki.model.Package");

        List<Package> result = query.getResultList();

        session.close();
        return result;
    }

    @Override
    public Package getPackageById(int id) {
        Session session = this.sessionFactory.openSession();
        Query<Package> query = session.createQuery("FROM tpackage WHERE id = :id");
        query.setParameter("id", id);
        Package result = null;
        try{
            result = query.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Nie znaleziono paczki");
        }
        session.close();
        return result;
    }

    @Override
    public Package getPackageByCode(String code) {
        Session session = this.sessionFactory.openSession();
        Query<Package> query = session.createQuery("FROM pl.edu.wszib.przesylki.model.Package WHERE code = :code");
        query.setParameter("code", code);

        Package result = null;
        try{
            result = query.getSingleResult();
        }catch (NoResultException e){
            System.out.println("Nie znaleziono paczki");
        }
        session.close();
        return result;
    }

    @Override
    public void editPackage(Package packages) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.update(packages);
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
    public void addPackage(Package packages) {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(packages);
            tx.commit();
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            }
        }finally {
            session.close();
        }
    }
}
