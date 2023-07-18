package org.example.dataAccess.concretes;

import org.example.dataAccess.abstracts.UserDao;
import org.example.entities.concretes.User;

import java.util.List;

public class HibernateUserDao implements UserDao {
    @Override
    public void add(User user) {
        System.out.println("You have successfully registered");
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User getEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
