package com.mattmessa.fitly.dao;

public class Challenge {
	
	private int challengeId;
	private String name;
	private int level;
	private String pictureUrl;
	private String description;
	private int coinsGiven;
	private int experienceGiven;
	
	
	public int getChallengeId() {
		return challengeId;
	}
	public void setChallengeId(int challengeId) {
		this.challengeId = challengeId;
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
	
	

}
