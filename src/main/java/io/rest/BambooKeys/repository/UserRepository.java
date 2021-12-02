package io.rest.BambooKeys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
