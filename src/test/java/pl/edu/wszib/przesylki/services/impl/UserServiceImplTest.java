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
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;
import pl.edu.wszib.przesylki.model.User;
import pl.edu.wszib.przesylki.model.UserAdmin;
import pl.edu.wszib.przesylki.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
@WebAppConfiguration
public class UserServiceImplTest {
    @Autowired
    IUserService userService;

    @MockBean
    IHibernateUserDAO hibernateUserDAO;


    //TODO
    @Test
    public void getUserByIdTest(){
        int id = 2;
        Mockito.when(this.hibernateUserDAO.getUserById(2)).thenReturn(new User(2, "kamil", "Wolak", "ul. Niepodleglosci 12 ", "459687156"));

        User result = userService.getUserById(id);
        //Assert.assertEquals();
    }

    @Test
    public void isUserInDBByNameTest(){

    }

}
