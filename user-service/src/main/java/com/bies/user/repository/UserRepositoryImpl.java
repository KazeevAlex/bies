package com.bies.user.repository;

import com.bies.user.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Override
    public List<User> findAll() {

        TypedQuery<User> theQuery = entityManager.createQuery("from User", User.class);

        List<User> users = theQuery.getResultList();

        return users;
    }

    @Override
    public User findById(int theId) {
        User user = entityManager.find(User.class, theId);
        return user;
    }

    @Override
    public User save(User theUser) {
        User dbUser = entityManager.merge(theUser);
        return dbUser;
    }

    @Override
    public void deleteById(int theId) {
        User user = entityManager.find(User.class, theId);
        entityManager.remove(user);
    }
}
