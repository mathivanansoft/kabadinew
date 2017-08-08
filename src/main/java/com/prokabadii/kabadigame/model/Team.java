package com.prokabadii.kabadigame.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Team")
public class Team {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="team_id")
	private Long teamId;
	@Column(name="team_name")
	private String teamName;
	@Column(name="team_zone")
	private Character teamZone;
	public Long getTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Character getTeamZone() {
		return teamZone;
	}
	public void setTeamZone(Character teamZone) {
		this.teamZone = teamZone;
	}
}
