package com.prokabadii.kabadigame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.prokabadii.kabadigame.model.Team;
import com.prokabadii.kabadigame.model.User;
import com.prokabadii.kabadigame.services.TeamService;

@RestController
public class TeamController {
	@Autowired
	TeamService teamService; 
@RequestMapping("allteams")
public ResponseEntity<?> getAllTeams(){
	List<Team> teamList=  teamService.getAllTeams();
	return new ResponseEntity<List>(teamList,HttpStatus.OK);
}

@RequestMapping("user/{userid}")
public ResponseEntity<?> getUser(@PathVariable("userid")Long userId){
	System.out.println("test");
	System.out.println("test "+teamService.findByUserId(userId).getName());
	User user = teamService.findByUserId(userId);
	return new ResponseEntity<User>(teamService.findByUserId(userId), HttpStatus.OK);
}

@RequestMapping(value = "/user/", method = RequestMethod.POST)
public ResponseEntity<?> createTeam(@RequestBody Team team, UriComponentsBuilder ucBuilder) {
	System.out.println("team data "+team.getTeamName()+" id"+team.getTeamId()+" zone "+team.getTeamZone());
	teamService.saveTeam(team);
    HttpHeaders headers = new HttpHeaders();
    headers.setLocation(ucBuilder.path("team/{id}").buildAndExpand(team).toUri());
    return new ResponseEntity<String>(headers, HttpStatus.CREATED);
}

}
