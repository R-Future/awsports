package com.awsports.pojo;

import java.util.List;

public class SinglematchQuery {

	private Singlematch singlematch;
	private User user1;
	private User user2;
	private Arena arena;
	private Tournament tournament;
	private List<Singlematchscore> singlematchscores;
	
	public List<Singlematchscore> getSinglematchscores() {
		return singlematchscores;
	}
	public void setSinglematchscores(List<Singlematchscore> singlematchscores) {
		this.singlematchscores = singlematchscores;
	}
	public Singlematch getSinglematch() {
		return singlematch;
	}
	public void setSinglematch(Singlematch singlematch) {
		this.singlematch = singlematch;
	}
	public User getUser1() {
		return user1;
	}
	public void setUser1(User user1) {
		this.user1 = user1;
	}
	public User getUser2() {
		return user2;
	}
	public void setUser2(User user2) {
		this.user2 = user2;
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
}
