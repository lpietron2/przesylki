package pl.edu.wszib.przesylki.services;


import pl.edu.wszib.przesylki.model.UserAdmin;

public interface IUserAdminService {
    void authenticate(UserAdmin userAdmin);
    void logout();


}
