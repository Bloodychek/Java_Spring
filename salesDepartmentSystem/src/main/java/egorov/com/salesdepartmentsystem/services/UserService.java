package egorov.com.salesdepartmentsystem.services;

import egorov.com.salesdepartmentsystem.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User findUserByEmail(String email);
    List<User> findAllUsers();
}
