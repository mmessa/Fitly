package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Challenge;
import com.mattmessa.fitly.dao.ChallengeDao;

@Service("challengesService")
public class ChallengeService {
	private ChallengeDao challengeDao;

	@Autowired
	public void setChallengeDao(ChallengeDao challengeDao) {
		this.challengeDao = challengeDao;
	}
		
	public List<Challenge> getChallenges() {
		return challengeDao.getChallenges();
	}

	public List<Challenge> getBeginnerChallenges() {
		return challengeDao.getBeginnerChallenges();
	}

	public List<Challenge> getIntermediateChallenges() {
		return challengeDao.getIntermediateChallenges();
	}

	public List<Challenge> getAdvancedChallenges() {
		return challengeDao.getAdvancedChallenges();
	}

	public List<Challenge> getCompletedChallenges(int userId) {
		return challengeDao.getCompletedChallenges(userId);
	}
}
