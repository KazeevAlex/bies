package com.bies.user.service;

import com.bies.user.model.User;
import com.bies.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        return userRepository.findById(theId);
    }

    @Transactional
    @Override
    public User save(User theUser) {
        return userRepository.save(theUser);
    }

    @Transactional
    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }
}
