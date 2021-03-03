package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.services.IPackageService;

import java.util.List;

@Service
public class PackageServiceImpl implements IPackageService {
    @Autowired
    IHibernatePackageDAO hibernatePackageDAO;

    @Override
    public List<Package> getAllPackages() {
        return this.hibernatePackageDAO.getAllPackages();
    }

    @Override
    public Package getPackageById(int id) {
        return this.hibernatePackageDAO.getPackageById(id);
    }

    @Override
    public Package getPackageByCode(String code) {
        return this.hibernatePackageDAO.getPackageByCode(code);
    }

    @Override
    public void editPackageInfo(Package packages) {
        this.hibernatePackageDAO.editPackage(packages);
    }

    @Override
    public void addPackage(Package packages) {
        this.hibernatePackageDAO.addPackage(packages);
    }


}
