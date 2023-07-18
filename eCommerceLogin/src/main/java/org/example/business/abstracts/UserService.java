package org.example.business.abstracts;

import org.example.entities.concretes.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
    boolean isEmailValid(String email);
}
