package io.rest.BambooKeys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.rest.BambooKeys.entity.Questions;

public interface QuestionsRepository extends JpaRepository<Questions, Long>{

    @Query("Select qu From questions qu Where ?1 = userFK")
    List<Questions> findAllReqByUserFK(Long userFK);
    
}
