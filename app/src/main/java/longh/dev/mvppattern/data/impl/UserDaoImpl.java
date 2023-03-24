package longh.dev.mvppattern.data.impl;

import java.util.List;

import longh.dev.mvppattern.data.dao.UserDao;
import longh.dev.mvppattern.data.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public User find(String email, String password) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
