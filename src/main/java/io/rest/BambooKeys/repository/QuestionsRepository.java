package io.rest.BambooKeys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.rest.BambooKeys.entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long>{
    
}
