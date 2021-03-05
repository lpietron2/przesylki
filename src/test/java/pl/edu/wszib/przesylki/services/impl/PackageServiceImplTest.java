package pl.edu.wszib.przesylki.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.przesylki.configuration.TestConfiguration;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.dao.IHibernateUserAdminDAO;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.Package;
import pl.edu.wszib.przesylki.services.IPackageService;
import pl.edu.wszib.przesylki.services.IUserAdminService;
import pl.edu.wszib.przesylki.services.IUserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class PackageServiceImplTest {
    @Autowired
    IUserService userService;

    @Autowired
    IUserAdminService userAdminService;

    @Autowired
    IPackageService packageService;

    @MockBean
    IHibernateUserDAO hibernateUserDAO;

    @MockBean
    IHibernateUserAdminDAO hibernateUserAdminDAO;

    @MockBean
    IHibernatePackageDAO hibernatePackageDAO;

    @Test
    public void getAllPackagesTest(){
        List<Package> packagesFromDB = new ArrayList<>();
        packagesFromDB.add(new Package(1, 1, 2, "20-02-2020", Package.Status.NADANY, "KKOO"));
        packagesFromDB.add(new Package(2, 1, 2, "20-02-2020", Package.Status.NADANY, "WWEE"));
        packagesFromDB.add(new Package(3, 1, 2, "20-02-2020", Package.Status.NADANY, "LKOI"));

        Mockito.when(this.hibernatePackageDAO.getAllPackages()).thenReturn(packagesFromDB);

        List<Package> packagesList = this.packageService.getAllPackages();


        Assert.assertNotNull(packagesList);
    }
}
