package com.awsports.pojo;

public class DoublesMatchQuery {
	private DoublesMatch doublesMatch;
	private Team home;
	private Team guest;
	public DoublesMatch getDoublesMatch() {
		return doublesMatch;
	}
	public void setDoublesMatch(DoublesMatch doublesMatch) {
		this.doublesMatch = doublesMatch;
	}
	public Team getHome() {
		return home;
	}
	public void setHome(Team home) {
		this.home = home;
	}
	public Team getGuest() {
		return guest;
	}
	public void setGuest(Team guest) {
		this.guest = guest;
	}
}
