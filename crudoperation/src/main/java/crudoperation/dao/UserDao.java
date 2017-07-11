package crudoperation.dao;

import crudoperation.entity.User;

import java.util.List;

/**
 * Created by axmedbek on 7/10/17.
 */
public interface UserDao {

    void save(User user);
    User findUserById(int id);
    List<User> allUser();
    void delete(int id);
    void update(User user);
}
