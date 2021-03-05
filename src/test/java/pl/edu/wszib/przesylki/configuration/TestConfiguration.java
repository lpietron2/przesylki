package pl.edu.wszib.przesylki.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.edu.wszib.przesylki.dao.IHibernatePackageDAO;
import pl.edu.wszib.przesylki.dao.IHibernateUserAdminDAO;
import pl.edu.wszib.przesylki.dao.IHibernateUserDAO;

@Configuration
@ComponentScan(basePackages = {
        "pl.edu.wszib.przesylki.controllers",
        "pl.edu.wszib.przesylki.services.impl",
        "pl.edu.wszib.przesylki.session"
})
public class TestConfiguration {
    /*@Bean
    public IHibernateUserDAO userDAO(){
        return Mockito.mock(IHibernateUserDAO.class);
    }

    @Bean
    public IHibernateUserAdminDAO userAdminDAO(){
        return Mockito.mock(IHibernateUserAdminDAO.class);
    }

    @Bean
    public IHibernatePackageDAO packageDAO(){
        return Mockito.mock(IHibernatePackageDAO.class);
    }*/

}
