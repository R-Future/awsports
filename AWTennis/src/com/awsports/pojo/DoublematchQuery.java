package com.awsports.pojo;

import java.util.List;

public class DoublematchQuery {
	private Doublematch doublematch;
	private List<Doublematchscore> doublematchscores;
	private Arena arena;
	private Tournament tournament;
	private TeamQuery hcTeamQuery;
	private TeamQuery apTeamQuery;
	public Doublematch getDoublematch() {
		return doublematch;
	}
	public void setDoublematch(Doublematch doublematch) {
		this.doublematch = doublematch;
	}
	public List<Doublematchscore> getDoublematchscores() {
		return doublematchscores;
	}
	public void setDoublematchscores(List<Doublematchscore> doublematchscores) {
		this.doublematchscores = doublematchscores;
	}
	public Arena getArena() {
		return arena;
	}
	public void setArena(Arena arena) {
		this.arena = arena;
	}
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	public TeamQuery getHcTeamQuery() {
		return hcTeamQuery;
	}
	public void setHcTeamQuery(TeamQuery hcTeamQuery) {
		this.hcTeamQuery = hcTeamQuery;
	}
	public TeamQuery getApTeamQuery() {
		return apTeamQuery;
	}
	public void setApTeamQuery(TeamQuery apTeamQuery) {
		this.apTeamQuery = apTeamQuery;
	}
}
