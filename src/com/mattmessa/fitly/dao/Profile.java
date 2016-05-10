package com.mattmessa.fitly.dao;

import java.sql.Blob;
import java.util.Date;

public class Profile {
	private int userId;
	private String firstName;
	private String lastName;
	private Blob image;
	private int heightFeet;
	private int heightInches;
	private Date DOB;
	private String gender;
	private String city;
	private String state;
	private int zipCode;
	private String gym;
	private int level;
	private int experiencePoints;
	private int coins;
	
	
	public Profile() {
	}
	
	public Profile(int userId, String firstName, String lastName, Blob image, int heightFeet, int heightInches,
			Date dOB, String gender, String city, String state, int zipCode, String gym, int level, int experiencePoints,
			int coins) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.image = image;
		this.heightFeet = heightFeet;
		this.heightInches = heightInches;
		DOB = dOB;
		this.gender = gender;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.gym = gym;
		this.level = level;
		this.experiencePoints = experiencePoints;
		this.coins = coins;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public int getUserId() {
		return userId;
	}

	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getHeightFeet() {
		return heightFeet;
	}
	public void setHeightFeet(int heightFeet) {
		this.heightFeet = heightFeet;
	}
	public int getHeightInches() {
		return heightInches;
	}
	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getGym() {
		return gym;
	}
	public void setGym(String gym) {
		this.gym = gym;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExperiencePoints() {
		return experiencePoints;
	}
	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}
	public int getCoins() {
		return coins;
	}
	public void setCoins(int coins) {
		this.coins = coins;
	}

	public boolean didLevelUp(int xp) {
		
		switch (this.level) {
		case 0: 
			if (this.experiencePoints + xp >= 1000) // LEVEL 1 EXPERIENCE
				return true;
			else
				return false;
		case 1:
			if (xp >= 3000) // LEVEL 2 EXPERIENCE
				return true;
			else
				return false;
		case 2:
			if (xp >= 7000) // LEVEL 3 EXPERIENCE
				return true;
			else
				return false;
		}
		return false;
	}

}
