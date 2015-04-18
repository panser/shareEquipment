package ua.org.gostroy.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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
        LOG.info(" setup(), testUser = " + testUser);
        testUser.setLogin(" setup");
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
        testUser.setLogin(" update");
        User updateUser = userDao.update(testUser);
        LOG.info(" update(), testUser = " + testUser);
        LOG.info(" update(), updateUser = " + updateUser);
        Assert.assertEquals(testUser.getId(),updateUser.getId());
    }

    @Test
    @Transactional
    public void save(){
        testUser.setLogin(" save");
        User saveUser = userDao.save(testUser);
        LOG.info(" save(), testUser = " + testUser);
        LOG.info(" save(), saveUser = " + saveUser);
        Assert.assertEquals(testUser.getId(), saveUser.getId());
    }
}
