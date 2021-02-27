package pl.edu.wszib.przesylki.services;

import pl.edu.wszib.przesylki.model.Package;

import java.util.List;


public interface IPackageService {
    List<Package> getAllPackages();
    Package getPackageById(int id);
    Package getPackageByCode(String code);
    Package updatePackageInfo(Package packages);
    Package addPackage(Package packages);
}
