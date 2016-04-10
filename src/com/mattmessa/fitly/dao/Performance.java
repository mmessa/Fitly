package com.mattmessa.fitly.dao;

public class Performance {

	private int performanceId;
	private int userId;
	private int challengeId;
	private String startedDate; //should be date time
	private String completedDate; //should be date time
	private int complete;
	private String name;
	private int level;
	private String pictureUrl;
	private String description;
	private int coinsGiven;
	private int experienceGiven;
	private int type;

	public Performance() {
		
	}
	
	public Performance(int performanceId, int userId, int challengeId, String startedDate, String completedDate,
			int complete, String name, int level, String pictureUrl, String description, int coinsGiven,
			int experienceGiven, int type) {
		super();
		this.performanceId = performanceId;
		this.userId = userId;
		this.challengeId = challengeId;
		this.startedDate = startedDate;
		this.completedDate = completedDate;
		this.complete = complete;
		this.name = name;
		this.level = level;
		this.pictureUrl = pictureUrl;
		this.description = description;
		this.coinsGiven = coinsGiven;
		this.experienceGiven = experienceGiven;
		this.type = type;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCoinsGiven() {
		return coinsGiven;
	}
	public void setCoinsGiven(int coinsGiven) {
		this.coinsGiven = coinsGiven;
	}
	public int getExperienceGiven() {
		return experienceGiven;
	}
	public void setExperienceGiven(int experienceGiven) {
		this.experienceGiven = experienceGiven;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPerformanceId() {
		return performanceId;
	}
	public void setPerformanceId(int performanceId) {
		this.performanceId = performanceId;
	}
	public String getStartedDate() {
		return startedDate;
	}
	public void setStartedDate(String startedDate) {
		this.startedDate = startedDate;
	}
	public String getCompletedDate() {
		return completedDate;
	}
	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}
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
	
	public int getComplete() {
		return complete;
	}
	public void setComplete(int completed) {
		this.complete = completed;
	}
	
	
	
	
}
