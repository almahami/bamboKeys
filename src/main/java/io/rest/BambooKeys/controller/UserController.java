package io.rest.BambooKeys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.service.UserService;


@RestController
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping("/username/{firstname}")
    public List<User> getUserWithName(@PathVariable String firstname){
        return userService.getUserWithName(firstname);
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    
    @PutMapping("user/{id}")
    public User updateUser(@PathVariable Long id , @RequestBody User user){
        return userService.replacUser(user, id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deletUSer(id);
    }

    @DeleteMapping("/users")
    public void deleteAllUSer(){
       userService.deleteAllUser();
    }

}
