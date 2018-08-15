package com.hitol.springboot.repository;

import com.hitol.springboot.model.trainTime.StationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<StationDO,Integer> {

    
}
