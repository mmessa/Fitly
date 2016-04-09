package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.BodyFat;
import com.mattmessa.fitly.dao.BodyFatDao;

@Service
public class BodyFatService {
	
	private BodyFatDao bodyFatDao;

	@Autowired
	public void setBodyFatDao(BodyFatDao bodyFatDao) {
		this.bodyFatDao = bodyFatDao;
	}

	public void create(BodyFat bodyFat) {
		bodyFatDao.create(bodyFat);
	}
	
	
	public List<BodyFat> getBodyFats(int userId) {
		return bodyFatDao.getBodyFats(userId);
	}
	
	public boolean updateBodyFat(BodyFat bodyFat) {
		return bodyFatDao.updateBodyFat(bodyFat);
	}
	
	public BodyFat getBodyFat(int bodyFatId) {
		
		if(bodyFatId == 0) {
			return null;
		}
		
		BodyFat bodyFat = bodyFatDao.getBodyFat(bodyFatId);
		
		if(bodyFat == null) {
			return null;
		}
		
		return bodyFat;
		
	}
	
	public void saveOrUpdate(BodyFat bodyFat) {
		
		if(bodyFat.getBodyFatId() != 0) {
			bodyFatDao.updateBodyFat(bodyFat);
		}
		
		else {
			bodyFatDao.create(bodyFat);
		}
		
	}

	public void deleteBodyFat(int bodyFatId) {
		bodyFatDao.deleteBodyFat(bodyFatId);
		
	}
}
