package com.awsports.pojo;

public class MatchStatistic {
	private StatisticQuery homeStatistic;
	private StatisticQuery guestStatistic;
	public StatisticQuery getHomeStatistic() {
		return homeStatistic;
	}
	public void setHomeStatistic(StatisticQuery homeStatistic) {
		this.homeStatistic = homeStatistic;
	}
	public StatisticQuery getGuestStatistic() {
		return guestStatistic;
	}
	public void setGuestStatistic(StatisticQuery guestStatistic) {
		this.guestStatistic = guestStatistic;
	}
	
}
