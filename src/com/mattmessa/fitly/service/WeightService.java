package com.mattmessa.fitly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mattmessa.fitly.dao.Weight;
import com.mattmessa.fitly.dao.WeightDao;

@Service("weightsService")
public class WeightService {

		private WeightDao weightDao;

		@Autowired
		public void setWeightDao(WeightDao weightDao) {
			this.weightDao = weightDao;
		}

		public void create(Weight weight) {
			weightDao.create(weight);
		}
		
		
		public List<Weight> getWeights(int userId) {
			return weightDao.getWeights(userId);
		}
		
		public boolean updateWeight(Weight weight) {
			return weightDao.updateWeight(weight);
		}
		
		public Weight getWeight(int weightId) {
			
			if(weightId == 0) {
				return null;
			}
			
			Weight weight = weightDao.getWeight(weightId);
			
			if(weight == null) {
				return null;
			}
			
			return weight;
			
		}
		
		public void saveOrUpdate(Weight weight) {
			
			if(weight.getWeightId() != 0) {
				weightDao.updateWeight(weight);
			}
			
			else {
			
				weightDao.create(weight);
			}
			
		}

		public void deleteWeight(int weightId) {
				
				weightDao.deleteWeight(weightId);
				return;
		}
	
}
