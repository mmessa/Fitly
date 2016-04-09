package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Update;
import com.mattmessa.fitly.dao.UpdateDao;

@Service("updatesService")
public class UpdateService {
	
	private UpdateDao updateDao;

	@Autowired
	public void setUpdateDao(UpdateDao updateDao) {
		this.updateDao = updateDao;
	}

	public void create(Update update) {
		updateDao.create(update);
	}
	
	
	public List<Update> getUpdates(int userId) {
		return updateDao.getUpdates(userId);
	}
	
	public boolean updateUpdate(Update update) {
		return updateDao.updateUpdate(update);
	}
	
	public Update getUpdate(int updateId) {
		
		if(updateId == 0) {
			return null;
		}
		
		Update update = updateDao.getUpdate(updateId);
		
		if(update == null) {
			return null;
		}
		
		return update;
		
	}
	
	public void saveOrUpdate(Update update) {
		
		if(update.getUpdateId() != 0) {
			updateDao.updateUpdate(update);
		}
		
		else {
			updateDao.create(update);
		}
		
	}

	public void deleteUpdate(int updateId) {
		updateDao.deleteUpdate(updateId);
	}

}
