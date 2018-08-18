package com.awsports.pojo;

public class PunishmentQuery {
	private Punishment punishment;
	private User user;
	private Tournament tournament;
	public Punishment getPunishment() {
		return punishment;
	}
	public void setPunishment(Punishment punishment) {
		this.punishment = punishment;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
}
