package com.prokabadii.kabadigame.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team_schedule")
public class MatchSchedule {
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="match_id")
	private Long matchId;
	@Column(name="team1")
	private Long team1;
	@Column(name="team2")
	private Long team2;
	@Column(name="match_time")
	private Date date;
	@Column(name="match_zone")
	private Character matchZone;
	public Character getMatchZone() {
		return matchZone;
	}
	public void setMatchZone(Character matchZone) {
		this.matchZone = matchZone;
	}
	public Long getMatchId() {
		return matchId;
	}
	public void setMatchId(Long matchId) {
		this.matchId = matchId;
	}
	public Long getTeam1() {
		return team1;
	}
	public void setTeam1(Long team1) {
		this.team1 = team1;
	}
	public Long getTeam2() {
		return team2;
	}
	public void setTeam2(Long team2) {
		this.team2 = team2;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
