package com.prokabadii.kabadigame.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prokabadii.kabadigame.model.Team;
import com.prokabadii.kabadigame.model.User;
import com.prokabadii.kabadigame.repositories.TeamRepository;
import com.prokabadii.kabadigame.repositories.UserRepository;


@Service
@Transactional
public class TeamServiceImpl implements TeamService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team findByTeamId(Long teamId){
		return teamRepository.findOne(teamId) ;
	}
	@Override
	 public User findByUserId(Long id){
		return userRepository.findOne(id);	
	}
	
	@Override
	public List<Team> getAllTeams(){
		return teamRepository.findAll();
	}
	@Override
	public Team saveTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}
}
