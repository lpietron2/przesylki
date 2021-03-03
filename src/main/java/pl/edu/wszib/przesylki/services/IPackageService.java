package pl.edu.wszib.przesylki.services;

import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.model.User;

import java.util.List;


public interface IPackageService {
    List<Package> getAllPackages();
    Package getPackageById(int id);
    Package getPackageByCode(String code);
    void editPackageInfo(Package packages);
    void addPackage(Package packages, User userFrom, User userTo);
    String codeGenerate();
}
