package com.mattmessa.fitly.dao;

public class Update {

	private int updateId;
	private int userId;
	private String notes;
	private String createDate;
	
	public Update(int updateId, int userId, String name, String notes, String createDate) {
		super();
		this.updateId = updateId;
		this.userId = userId;
		this.notes = notes;
		this.createDate = createDate;
	}
	
	public Update() {
	}

	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
	
}
