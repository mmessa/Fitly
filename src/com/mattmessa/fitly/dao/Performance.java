package com.mattmessa.fitly.dao;

import java.sql.Date;

public class Performance {

	private int userId;
	private int challengeId;
	private Date startedDateTime; //should be date time
	private boolean completed;
	private Date completedDateTime;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getChallengeId() {
		return challengeId;
	}
	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
	}
	public Date getStartedDateTime() {
		return startedDateTime;
	}
	public void setStartedDateTime(Date startedDateTime) {
		this.startedDateTime = startedDateTime;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public Date getCompletedDateTime() {
		return completedDateTime;
	}
	public void setCompletedDateTime(Date completedDateTime) {
		this.completedDateTime = completedDateTime;
	}
	
	
	
}
