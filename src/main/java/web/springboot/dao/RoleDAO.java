package web.springboot.dao;

import web.springboot.model.Role;

import java.util.List;

public interface RoleDAO {
    void createRole(Role role);
    List<Role> getAllRole();
    Role getRoleById(int id);
}
