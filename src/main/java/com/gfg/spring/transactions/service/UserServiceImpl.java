package com.gfg.spring.transactions.service;

import com.gfg.spring.transactions.model.User;
import com.gfg.spring.transactions.model.dto.UserDTO;
import com.gfg.spring.transactions.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDTO getUser(int id) {
        User userById = userRepository.getUserById(id);
        return modelMapper.map(userById, UserDTO.class);
    }
}
