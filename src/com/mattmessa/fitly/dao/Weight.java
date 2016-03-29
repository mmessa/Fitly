package com.mattmessa.fitly.dao;

public class Weight {
	private int weightId;
	private int userId;
	private String createDate;
	private double weight;
	
	public int getWeightId() {
		return weightId;
	}
	public void setWeightId(int weightId) {
		this.weightId = weightId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	
}
