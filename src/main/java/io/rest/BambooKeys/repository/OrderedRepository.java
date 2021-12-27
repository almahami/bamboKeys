package io.rest.BambooKeys.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.rest.BambooKeys.entity.Ordered;

public interface OrderedRepository extends JpaRepository<Ordered, Long> {

    @Query("SELECT o  FROM  ordered o where ?1 =userFK")
    List<Ordered> findAllOrderWithUserFK(Long userFK);
    
}
