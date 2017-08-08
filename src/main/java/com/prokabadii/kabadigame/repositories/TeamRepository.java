package com.prokabadii.kabadigame.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prokabadii.kabadigame.model.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team,Long>{
	

}
