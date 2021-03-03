package pl.edu.wszib.przesylki.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.services.IPackageService;
import pl.edu.wszib.przesylki.services.IUserService;

import java.awt.*;
import java.util.List;
import java.util.Random;

@Service
public class PackageServiceImpl implements IPackageService {
    @Autowired
    IHibernatePackageDAO hibernatePackageDAO;
    @Autowired
    IUserService userService;

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
    public void addPackage(Package packages, User userFrom, User userTo) {
        this.userService.isUserInDB(userFrom);
        this.userService.isUserInDB(userTo);

        System.out.println(userFrom.toString());
        System.out.println(userTo.toString());

        //this.hibernatePackageDAO.addPackage(packages);
    }

    @Override
    public String codeGenerate() {
        String codeLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rd = new Random();
        String letter = "";
        for(int i=0; i<4; i++) {
            letter += codeLetters.charAt(rd.nextInt(codeLetters.length()));
        }
        return letter;
    }
}
