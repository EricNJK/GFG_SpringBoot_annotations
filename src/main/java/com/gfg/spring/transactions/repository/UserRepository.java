package com.gfg.spring.transactions.repository;

import com.gfg.spring.transactions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserById(int id);
}
