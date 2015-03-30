package ua.org.gostroy.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.model.persistance.User;

import java.util.List;

/**
 * Created by Sergey on 3/29/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
public class UserDaoTest {

    private final Logger LOG = LogManager.getLogger(getClass());
    User testUser;

    @Autowired
    UserDao userDao;

    @Before
    @Transactional
    public void setup(){
        testUser = new User();
        testUser.setLogin(getClass() + ": setup");
        testUser = userDao.save(testUser);
    }

    @Test
    @Transactional
    public void findAll(){
        List<User> users = userDao.findAll();
        Assert.assertNotEquals(users.size(), 0);
    }

    @Test
    @Transactional
    public void update(){
        testUser.setLogin(getClass() + ": update");
        User updateUser = userDao.update(testUser);
        LOG.trace(getClass() + ": update(), testUser = " + testUser);
        LOG.trace(getClass() + ": update(), updateUser = " + updateUser);
        Assert.assertEquals(testUser.getId(),updateUser.getId());
    }

    @Test
    @Transactional
    public void save(){
        testUser.setLogin(getClass() + ": save");
        User saveUser = userDao.save(testUser);
        LOG.trace(getClass() + ": save(), testUser = " + testUser);
        LOG.trace(getClass() + ": save(), saveUser = " + saveUser);
        Assert.assertEquals(testUser.getId(), saveUser.getId());
    }
}
