package com.awsports.pojo;

/**
 * 
 * @Company: aiwangsports.com
 * @Version: 1.1
 * @Author: peRFect
 * @Date: 2018年7月7日 下午1:59:49
 * @Package: com.awsports.pojo
 * @Description: combinational querying between table aw_event, aw_event_player and aw_event_worker
 *
 */
public class EventQuery {
	
	private Event event;
	private User userPublisher;
	private User userContact;
	
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	public User getUserPublisher() {
		return userPublisher;
	}
	public void setUserPublisher(User userPublisher) {
		this.userPublisher = userPublisher;
	}
	public User getUserContact() {
		return userContact;
	}
	public void setUserContact(User userContact) {
		this.userContact = userContact;
	}
	
}
