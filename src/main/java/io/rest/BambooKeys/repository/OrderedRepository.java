package io.rest.BambooKeys.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import io.rest.BambooKeys.entity.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, Long> {

    @Transactional
    @Modifying
    @Query("SELECT id FROM ordered where ?1 =userFK")
    List<Ordered> findAllOrderWithUserFK(Long userFK);
    
}
