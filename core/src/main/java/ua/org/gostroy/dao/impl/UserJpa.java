package ua.org.gostroy.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.dao.UserDao;
import ua.org.gostroy.model.persistance.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Sergey on 3/29/2015.
 */
@Repository
public class UserJpa implements UserDao {

    private final Logger LOG = LogManager.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    @Override
    public User findOne(Long id) {
        User user = em.find(User.class, id);
        return user;
    }

    @Override
    public List<User> findAll() {
        Query query = em.createQuery("SELECT e FROM User e");
        List users = (List<User>) query.getResultList();
        return users;
    }

    @Override
    public User save(User user) {
        em.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        User newUser = em.merge(user);
        return newUser;
    }

    @Override
    public void delete(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

}
