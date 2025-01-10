package com.gfg.spring.transactions.service;

import com.gfg.spring.transactions.model.User;
import com.gfg.spring.transactions.model.dto.UserDTO;

public interface UserService {

    UserDTO createUser(User user);

    UserDTO getUser(int id);
}
