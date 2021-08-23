package web.springboot.dao;

import org.springframework.stereotype.Repository;
import web.springboot.model.Role;

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
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = getEntityManager()
                    .createQuery("SELECT r FROM Role r WHERE r.role=:name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return role;
    }
}
