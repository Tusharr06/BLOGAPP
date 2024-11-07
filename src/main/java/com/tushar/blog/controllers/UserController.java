package com.tushar.blog.controllers;

import com.tushar.blog.model.User;
import com.tushar.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public ResponseEntity<User> login(@RequestBody User user) {
     userService.createUser(user);
     return ResponseEntity.ok(user);
    }
    @GetMapping("login")
    public ResponseEntity <List<User>> login() {
        List<User> us = userService.getAllUser();
        return ResponseEntity.ok(us);
    }
    @PutMapping("login")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }
    @GetMapping("login/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id, @RequestBody User user) {
        userService.getUserById(id);
        return ResponseEntity.ok(user);

    }
    @DeleteMapping("login/{id}")
public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Deleted user");
}



}
