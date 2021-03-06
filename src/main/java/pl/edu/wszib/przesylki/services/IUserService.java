package pl.edu.wszib.przesylki.services;

import pl.edu.wszib.przesylki.model.User;

public interface IUserService {
    User getUserById(int id);
    void addNewUser(User user);
    void isUserInDB(User user);
    User isUserInDBByName(User user);
}
