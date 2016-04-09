package com.mattmessa.fitly.dao;

public class BodyFat {

	private int bodyFatId;
	private int userId;
	private String createDate;
	private double bodyFatPercentage;
	
	
	public BodyFat() {
	}

	public BodyFat(int bodyFatId, int userId, String createDate, double bodyFatPercentage) {
		super();
		this.bodyFatId = bodyFatId;
		this.userId = userId;
		this.createDate = createDate;
		this.bodyFatPercentage = bodyFatPercentage;
	}
	
	public int getBodyFatId() {
		return bodyFatId;
	}
	public void setBodyFatId(int bodyFatId) {
		this.bodyFatId = bodyFatId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getBodyFatPercentage() {
		return bodyFatPercentage;
	}
	public void setBodyFatPercentage(double bodyFatPercentage) {
		this.bodyFatPercentage = bodyFatPercentage;
	}
	
	
}
