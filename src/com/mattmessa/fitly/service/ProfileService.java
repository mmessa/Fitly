package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Profile;
import com.mattmessa.fitly.dao.ProfileDao;

@Service("profilesService")
public class ProfileService {

	private ProfileDao profileDao;

	@Autowired
	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	public void create(Profile profile) {
		profileDao.create(profile);
	}
	
	/*
	public List<Profile> getProfiles() {
		return profileDao.getProfiles();
	}
	*/
	
	
	public Profile getProfile(int userId) {
		return profileDao.getProfile(userId);
	}
	
	
	
}
