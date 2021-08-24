package web.springboot.dao;

import org.springframework.stereotype.Repository;
import web.springboot.model.Role;
import web.springboot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDAOImp implements RoleDAO {
    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public void createRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public List<Role> getAllRole() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public Role getRoleById(int id) {
        return entityManager.find(Role.class, id);
    }
}
