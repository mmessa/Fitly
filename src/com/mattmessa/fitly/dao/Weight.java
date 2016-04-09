package com.mattmessa.fitly.dao;

public class Weight {
	private int weightId;
	private int userId;
	private int updateId;
	private String createDate;
	private double weight;
	
	public Weight() {
		this.updateId = 0;
	}
	
	public Weight(int weightId, int userId, int updateId, String createDate, double weight) {
		super();
		this.weightId = weightId;
		this.userId = userId;
		this.updateId = updateId;
		this.createDate = createDate;
		this.weight = weight;
	}
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
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
