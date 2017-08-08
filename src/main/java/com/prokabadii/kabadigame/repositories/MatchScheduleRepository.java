package com.prokabadii.kabadigame.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prokabadii.kabadigame.model.MatchSchedule;

@Repository
public interface MatchScheduleRepository extends JpaRepository<MatchSchedule,Long>{

}
