package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Performance;
import com.mattmessa.fitly.dao.PerformanceDao;

@Service
public class PerformanceService {
	private PerformanceDao performanceDao;

	@Autowired
	public void setPerformanceDao(PerformanceDao performanceDao) {
		this.performanceDao = performanceDao;
	}

	public void create(Performance performance) {
		performanceDao.create(performance);
	}
	
	
	public List<Performance> getPerformances(int userId) {
		return performanceDao.getPerformances(userId);
	}
	
	public boolean completePerformance(int performanceId) {
		return performanceDao.completePerformance(performanceId);
	}
	
	public void deletePerformance(int performanceId) {
			
			performanceDao.deletePerformance(performanceId);
			return;
	}
}
