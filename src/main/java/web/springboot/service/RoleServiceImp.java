package web.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.springboot.dao.RoleDAO;
import web.springboot.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImp implements RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public void setRoleRepo(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    public void createRole(Role role) {
        roleDAO.createRole(role);
    }

    @Override
    public List<Role> getAllRole() {
        return roleDAO.getAllRole();
    }

    @Override
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }
}
