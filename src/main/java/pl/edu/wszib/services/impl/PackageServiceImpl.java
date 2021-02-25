package pl.edu.wszib.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.dao.IHibernatePackageDAO;
import pl.edu.wszib.model.Package;
import pl.edu.wszib.services.IPackageService;

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
        return null;
    }

    @Override
    public Package updatePackageInfo(Package packages) {
        return null;
    }

    @Override
    public Package addPackage(Package packages) {
        return null;
    }

}
