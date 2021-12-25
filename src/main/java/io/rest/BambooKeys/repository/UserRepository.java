package io.rest.BambooKeys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
   
    List<User> findByFirstname(String firstname);
    //List<User> findByLastname(String lastname);
   //  List<User> findByE_mail(String e_mail);
    
}
