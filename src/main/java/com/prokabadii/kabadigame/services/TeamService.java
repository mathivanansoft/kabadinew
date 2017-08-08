package com.prokabadii.kabadigame.services;

import java.util.List;

import com.prokabadii.kabadigame.model.Team;
import com.prokabadii.kabadigame.model.User;

public interface TeamService {
	public Team findByTeamId(Long teamId);
	public User findByUserId(Long teamId);
	public List<Team> getAllTeams();
	public Team saveTeam(Team team);
}
