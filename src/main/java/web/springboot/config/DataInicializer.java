package web.springboot.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import web.springboot.model.Role;
import web.springboot.model.User;
import web.springboot.service.RoleService;
import web.springboot.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInicializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInicializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void saveUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.createRole(role1);
        roleService.createRole(role2);
        User user1 = new User("admin", "Иван", "Иванов", (byte) 29,
                "ivanov@mail.ru", "1", role1, role2);
        userService.createUser(user1);
        User user2 = new User("user", "Ирина", "Лапина", (byte) 35,
                "lapina@mail.ru", "2", role2);
        userService.createUser(user2);
    }
}
