package com.mattmessa.fitly.dao;

import java.util.Date;	

public class BodyFat {

	private int bodyFatId;
	private int userId;
	private String createDate;
	private double bodyFatPercentage;
	
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
