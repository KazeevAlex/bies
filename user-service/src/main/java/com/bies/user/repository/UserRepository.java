package com.bies.user.repository;

import com.bies.user.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
