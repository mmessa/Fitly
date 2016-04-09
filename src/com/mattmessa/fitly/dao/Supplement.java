package com.mattmessa.fitly.dao;

public class Supplement {
	
	private int supplementId;
	private int userId;
	private String name;
	
	
	
	public Supplement() {
	}
	public Supplement(int supplementId, int userId, String name) {
		super();
		this.supplementId = supplementId;
		this.userId = userId;
		this.name = name;
	}
	public int getSupplementId() {
		return supplementId;
	}
	public void setSupplementId(int supplementId) {
		this.supplementId = supplementId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
