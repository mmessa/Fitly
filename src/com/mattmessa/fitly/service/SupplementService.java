package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Supplement;
import com.mattmessa.fitly.dao.SupplementDao;

@Service("supplementsService")
public class SupplementService {
	
	private SupplementDao supplementDao;

	@Autowired
	public void setSupplementDao(SupplementDao supplementDao) {
		this.supplementDao = supplementDao;
	}

	public void create(Supplement supplement) {
		supplementDao.create(supplement);
	}
	
	
	public List<Supplement> getSupplements(int userId) {
		System.out.println("made it into supp service\n");
		return supplementDao.getSupplements(userId);
	}
	
	public boolean updateSupplement(Supplement supplement) {
		return supplementDao.updateSupplement(supplement);
	}
	
	public Supplement getSupplement(int supplementId) {
		
		if(supplementId == 0) {
			return null;
		}
		
		Supplement supplement = supplementDao.getSupplement(supplementId);
		
		if(supplement == null) {
			return null;
		}
		
		return supplement;
		
	}
	
	public void saveOrUpdate(Supplement supplement) {

		if(supplement.getSupplementId() != 0) {
			supplementDao.updateSupplement(supplement);
		}
		
		else {
		
			supplementDao.create(supplement);
		}
		
	}

	public void deleteSupplement(int supplementId) {
		
		supplementDao.deleteSupplement(supplementId);
	}
}
