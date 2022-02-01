package service.dao;

import domain.User;

import java.util.List;

public interface UserDao {

    User getById(long id);
    List<User> getAll();
    User create(User user);
    User update(User user,long id);
    boolean remove(long id);
}
