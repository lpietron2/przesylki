package pl.edu.wszib.przesylki.dao;

import pl.edu.wszib.przesylki.model.Package;

import java.util.List;

public interface IHibernatePackageDAO {
    List<Package> getAllPackages();
    Package getPackageById(int id);
    Package getPackageByCode(String code);
    void editPackage(Package packages);
    void addPackage(Package packages);
}
