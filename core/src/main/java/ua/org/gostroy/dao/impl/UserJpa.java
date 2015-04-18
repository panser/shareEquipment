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
        LOG.trace("findOne ... ");
        User user = em.find(User.class, id);
        if (user != null) {
            LOG.trace("findOne. ");
        }
        else {
            LOG.trace("findOne. Not found.");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        LOG.trace("findAll ... ");
        Query query = em.createQuery("SELECT e FROM User e");
        List users = (List<User>) query.getResultList();
        LOG.trace("findAll. ");
        return users;
    }

    @Override
    public User save(User user) {
        LOG.trace("save ... ");
        em.persist(user);
        LOG.trace("save. ");
        return user;
    }

    @Override
    public User update(User user) {
        LOG.trace("update ... ");
        User newUser = em.merge(user);
        LOG.trace("update. ");
        return newUser;
    }

    @Override
    public void delete(User user) {
        LOG.trace("delete ... ");
        em.remove(em.contains(user) ? user : em.merge(user));
        LOG.trace("delete. ");
    }

}
