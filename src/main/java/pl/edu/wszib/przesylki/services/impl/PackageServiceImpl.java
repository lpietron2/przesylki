package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.services.IPackageService;

import java.util.List;
//TODO napisac servisy i dao do tego
@Service
public class PackageServiceImpl implements IPackageService {
    @Autowired
    IHibernatePackageDAO hibernatePackageDAO;

    @Override
    public List<Package> getAllPackages() {
        this.hibernatePackageDAO.getAllPackages();
        return null;
    }

    @Override
    public Package getPackageById(int id) {
        this.hibernatePackageDAO.getPackageById(id);
        return null;
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
    public Package addPackage(Package packages) {
        return null;
    }

}
