package web.springboot.service;

import web.springboot.model.Role;

import java.util.List;

public interface RoleService {
    void createRole(Role role);
    List<Role> getAllRole();
    Role getRoleById(int id);
}
