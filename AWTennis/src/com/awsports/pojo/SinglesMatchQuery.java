package com.awsports.pojo;

public class SinglesMatchQuery {

	private SinglesMatch singlesMatch;
	private User home;
	private User guest;

	public SinglesMatch getSinglesMatch() {
		return singlesMatch;
	}
	public void setSinglesMatch(SinglesMatch singlesMatch) {
		this.singlesMatch = singlesMatch;
	}
	public User getHome() {
		return home;
	}
	public void setHome(User home) {
		this.home = home;
	}
	public User getGuest() {
		return guest;
	}
	public void setGuest(User guest) {
		this.guest = guest;
	}
	
}
