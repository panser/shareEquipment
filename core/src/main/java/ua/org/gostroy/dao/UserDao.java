package ua.org.gostroy.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.org.gostroy.model.persistance.User;

import java.util.List;

/**
 * Created by Sergey on 3/29/2015.
 */
public interface UserDao {

    User findOne(Long id);
    List<User> findAll();
    User save(User user);
    User update(User user);
    void delete(User user);

}
