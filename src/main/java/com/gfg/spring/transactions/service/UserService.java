package com.gfg.spring.transactions.service;

import com.gfg.spring.transactions.model.User;

public interface UserService {

    User createUser(User user);

    User getUser(int id);
}
