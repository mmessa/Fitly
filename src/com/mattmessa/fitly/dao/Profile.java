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
	private char gender;
	private String city;
	private String state;
	private int zipCode;
	private String gym;
	private int level;
	private int experiencePoints;
	private int coins;
	
	private User user;
	
	public Profile() {
		
	}
	
	
	public Profile(int userId, String firstName, String lastName, Blob image, int heightFeet, int heightInches,
			Date dOB, char gender, String city, String state, int zipCode, String gym, int level, int experiencePoints,
			int coins, User user) {
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
		this.user = user;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
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

	@Override
	public String toString() {
		return "Profile [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", image=" + image
				+ ", heightFeet=" + heightFeet + ", heightInches=" + heightInches + ", DOB=" + DOB + ", gender="
				+ gender + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", gym=" + gym + ", level="
				+ level + ", experiencePoints=" + experiencePoints + ", coins=" + coins + ", user=" + user + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((DOB == null) ? 0 : DOB.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + coins;
		result = prime * result + experiencePoints;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + gender;
		result = prime * result + ((gym == null) ? 0 : gym.hashCode());
		result = prime * result + heightFeet;
		result = prime * result + heightInches;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + level;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + zipCode;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (DOB == null) {
			if (other.DOB != null)
				return false;
		} else if (!DOB.equals(other.DOB))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (coins != other.coins)
			return false;
		if (experiencePoints != other.experiencePoints)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gender != other.gender)
			return false;
		if (gym == null) {
			if (other.gym != null)
				return false;
		} else if (!gym.equals(other.gym))
			return false;
		if (heightFeet != other.heightFeet)
			return false;
		if (heightInches != other.heightInches)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (level != other.level)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (zipCode != other.zipCode)
			return false;
		return true;
	}

	
	
	
	
	
	
	
}
