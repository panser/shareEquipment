package ua.org.gostroy.dao;

import ua.org.gostroy.model.persistance.Equipment;

import java.util.List;

/**
 * Created by Sergey on 3/29/2015.
 */
public interface EquipmentDao {

    Equipment findOne(Long id);
    List<Equipment> findAll();
    Equipment save(Equipment equipment);
    Equipment update(Equipment equipment);
    void delete(Equipment equipment);

}
