package web.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import web.springboot.model.User;

import java.util.ArrayList;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
    void createUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    void updateUser(User user);
}
