package com.gfg.spring.transactions.service;

import com.gfg.spring.transactions.model.User;
import com.gfg.spring.transactions.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUser(int id) {
        return userRepository.getUserById(id);
    }
}
