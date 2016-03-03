package com.mattmessa.fitly.dao;

import java.util.Date;

public class BodyFat {

	private int userId;
	private Date createdAtDate;
	private double bodyFatPercentage;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getCreatedAtDate() {
		return createdAtDate;
	}
	public void setCreatedAtDate(Date createdAtDate) {
		this.createdAtDate = createdAtDate;
	}
	public double getBodyFatPercentage() {
		return bodyFatPercentage;
	}
	public void setBodyFatPercentage(double bodyFatPercentage) {
		this.bodyFatPercentage = bodyFatPercentage;
	}
	
	
}
