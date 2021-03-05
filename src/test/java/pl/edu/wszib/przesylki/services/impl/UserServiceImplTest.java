package pl.edu.wszib.przesylki.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import pl.edu.wszib.przesylki.AppConfiguration;
import pl.edu.wszib.przesylki.configuration.TestConfiguration;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.dao.IHibernateUserAdminDAO;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.services.IPackageService;
import pl.edu.wszib.przesylki.services.IUserAdminService;
import pl.edu.wszib.przesylki.services.IUserService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {
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
    public void getUserByIdTest(){
        int id = 2;
        User user = new User(2, "kamil", "Wolak", "ul. Niepodleglosci 12 ", "459687156");
        Mockito.when(this.hibernateUserDAO.getUserById(2)).thenReturn(user);

        User result = userService.getUserById(id);
        Assert.assertEquals(user, result);
    }

    @Test
    public void isUserInDBByNameTest_ListNull(){
        User user = new User(0, "kamil", "Wolak", "ul. Niepodleglosci 12 ", "459687156");
        Mockito.when(this.hibernateUserDAO.getUserByName("kamil", "Wolak")).thenReturn(null);
        Mockito.when(this.hibernateUserDAO.persistUser(user)).thenReturn(user);

        User result = this.userService.isUserInDBByName(user);

        Assert.assertEquals(user, result);
    }

    @Test
    public void isUserInDBByNameTest_UserInDB(){
        User user = new User(0, "kamil", "Wolak", "ul. Niepodleglosci 12 ", "459687156");
        List<User> userList = new ArrayList<>();
        userList.add(user);
        Mockito.when(this.hibernateUserDAO.getUserByName("kamil", "Wolak")).thenReturn(userList);
        Mockito.when(this.hibernateUserDAO.persistUser(user)).thenReturn(null);

        User result = this.userService.isUserInDBByName(user);

        Assert.assertEquals(user, result);
    }

}
