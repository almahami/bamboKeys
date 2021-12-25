package io.rest.BambooKeys.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.rest.BambooKeys.entity.User;
import io.rest.BambooKeys.exception.UserNotfoundException;
import io.rest.BambooKeys.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private  UserRepository userRepository;
    private  Logger log;

    public UserService(Logger log){
        this.log = log;
    }

    // List All user
    public List<User> getUsers(){
        log.info("get all user" +  userRepository.findAll());
        return userRepository.findAll();
    }

    //Get user with id 
    public User getUser(Long id){
        Optional<User> res = userRepository.findById(id);
        if(res.isEmpty()) throw new  UserNotfoundException(id);
        log.info("Get user with id" + res.get().getId());
        log.info("User" + res.get());
        return res.get();
    }

    // Create a new User
    public User addUser(User user){
        User newUser = userRepository.save(user);
        log.info("++++++++++++++++++++user++++++++++++++" + user.toString());
        log.info("Saved user with id" + newUser.getId());
        log.info("user saved" + newUser.toString());
        return newUser;
    }

    // replace user with id --> newuser info 
    public User replacUser(User newUser, Long id ){

        return userRepository.findById(id)
            .map(user -> {
                log.info("old User" + userRepository.findById(id).get());
                user.setLastname(newUser.getLastname());
                user.setFirstname(newUser.getFirstname());
                user.setE_mail(newUser.getE_mail());
                user.setAdress(newUser.getAdress());
                user.setSalutation(newUser.getSalutation());
              
                log.info("new User" + user.toString());
                return userRepository.save(user);
        })
        
        .orElseThrow( () -> new UserNotfoundException(id));
    }

    // delete User with id
    public void deletUSer(Long id){
        Optional<User> res = userRepository.findById(id);

        if (res.isPresent()){
            log.warn("Delete the user with id " + id);
            userRepository.deleteById(id); 
        }
        else{
            throw new UserNotfoundException(id);
        }
    }

    public  void deleteAllUser(){
        List<User> result = userRepository.findAll();
        if (result.isEmpty()) throw new UserNotfoundException("dose not found any User "); 
        
        log.warn("Delete ALL user ");
        userRepository.deleteAll();
    }
}
