package com.gfg.spring.transactions.controller;

import com.gfg.spring.transactions.model.User;
import com.gfg.spring.transactions.model.dto.UserDTO;
import com.gfg.spring.transactions.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId) {
        UserDTO userDto = userService.getUser(userId);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody User user) {
        UserDTO created = userService.createUser(user);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
