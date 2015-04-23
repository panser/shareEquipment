package ua.org.gostroy.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.org.gostroy.model.persistance.Equipment;
import ua.org.gostroy.model.persistance.User;

import java.util.List;

/**
 * Created by Sergey on 3/29/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml"})
@TransactionConfiguration(defaultRollback = true)
public class EquipmentDaoTest {

    private final Logger LOG = LogManager.getLogger(getClass());
    Equipment testEquipment;

    @Autowired
    EquipmentDao equipmentDao;

    @Before
    @Transactional
    public void setup(){
        testEquipment = new Equipment();
        User testUser = new User();
        LOG.info(" setup(), testEquipment = " + testEquipment);
        testEquipment.setName(" setup");
        testEquipment.setUser(testUser);
        testEquipment = equipmentDao.save(testEquipment);
    }

    @Test
    @Transactional
    public void findAll(){
        List<Equipment> equipments = equipmentDao.findAll();
        Assert.assertNotEquals(equipments.size(), 0);
    }

    @Test
    @Transactional
    public void update(){
        testEquipment.setName(" update");
        Equipment updateEquipment = equipmentDao.update(testEquipment);
        LOG.info(" update(), testEquipment = " + testEquipment);
        LOG.info(" update(), updateEquipment = " + updateEquipment);
        Assert.assertEquals(testEquipment.getId(),updateEquipment.getId());
    }

    @Test
    @Transactional
    public void save(){
        testEquipment.setName(" save");
        Equipment saveEquipment = equipmentDao.save(testEquipment);
        LOG.info(" save(), testEquipment = " + testEquipment);
        LOG.info(" save(), saveEquipment = " + saveEquipment);
        Assert.assertEquals(testEquipment.getId(), saveEquipment.getId());
    }
}
