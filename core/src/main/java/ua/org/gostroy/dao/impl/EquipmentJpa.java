package ua.org.gostroy.dao.impl;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ua.org.gostroy.dao.EquipmentDao;
import ua.org.gostroy.model.persistance.Equipment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Sergey on 3/29/2015.
 */
@Repository
public class EquipmentJpa implements EquipmentDao {

    private final Logger LOG = LogManager.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    @Override
    public Equipment findOne(Long id) {
        Equipment equipment = em.find(Equipment.class, id);
        return equipment;
    }

    @Override
    public List<Equipment> findAll() {
        Query query = em.createQuery("SELECT e FROM Equipment e");
        List equipments = (List<Equipment>) query.getResultList();
        return equipments;
    }

    @Override
    public Equipment save(Equipment equipment) {
        em.persist(equipment);
        return equipment;
    }

    @Override
    public Equipment update(Equipment equipment) {
        Equipment newEquipment = em.merge(equipment);
        return newEquipment;
    }

    @Override
    public void delete(Equipment equipment) {
        em.remove(em.contains(equipment) ? equipment : em.merge(equipment));
    }

}
