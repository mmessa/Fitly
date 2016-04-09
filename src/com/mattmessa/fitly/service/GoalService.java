package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Goal;
import com.mattmessa.fitly.dao.GoalDao;

@Service("goalsService")
public class GoalService {

	private GoalDao goalDao;

	@Autowired
	public void setGoalDao(GoalDao goalDao) {
		this.goalDao = goalDao;
	}

	public void create(Goal goal) {
		goalDao.create(goal);
	}
	
	
	public List<Goal> getGoals(int userId) {
		return goalDao.getGoals(userId);
	}
	
	public boolean updateGoal(Goal goal) {
		return goalDao.updateGoal(goal);
	}
	
	public Goal getGoal(int goalId) {
		
		if(goalId == 0) {
			return null;
		}
		
		Goal goal = goalDao.getGoal(goalId);
		
		if(goal == null) {
			return null;
		}
		
		return goal;
		
	}
	
	public void saveOrUpdate(Goal goal) {
		
		if(goal.getGoalId() != 0) {
			goalDao.updateGoal(goal);
		}
		
		else {
		
			goalDao.create(goal);
		}
		
	}

	public void deleteGoal(int goalId) {
		goalDao.deleteGoal(goalId);
		
	}
}
