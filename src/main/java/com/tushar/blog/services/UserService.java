package com.tushar.blog.services;

import com.tushar.blog.model.User;
import com.tushar.blog.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService   {
    @Autowired
    private UserRepo userRepo;
   public User createUser(User user){
        userRepo.save(user);
        return user;
    }
    public User updateUser(User user){
        return userRepo.save(user);
    }
    public User getUserById(int id){
        return userRepo.findById(id).get();
    }
    public List<User> getAllUser(){
        return userRepo.findAll();
    }
   public User deleteUser(int id){
        User user = userRepo.findById(id).get();
        userRepo.delete(user);
        return user;
    }
    public List<User> getUserByUsername(String username){
        return userRepo.findByName(username);
    }


}
