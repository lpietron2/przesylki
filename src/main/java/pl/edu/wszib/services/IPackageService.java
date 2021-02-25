package pl.edu.wszib.services;

import org.springframework.stereotype.Service;
import pl.edu.wszib.model.Package;

import java.util.List;

public interface IPackageService {
    List<Package> getAllPackages();
    Package getPackageById(int id);
    Package updatePackageInfo(Package packages);
    Package addPackage(Package packages);
}
