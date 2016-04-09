package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("WeightDAO")
public class WeightDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(Weight weight) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", weight.getUserId());
		params.addValue("updateId", weight.getUpdateId());
		params.addValue("weight", weight.getWeight());
		
		return jdbc.update("insert into weight (userId, updateId, weight) values (:userId, :updateId, :weight)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public Weight getWeight(int weightId) {
		
		
		System.out.printf("dao id = %d", weightId);

		MapSqlParameterSource params = new MapSqlParameterSource("weightId", weightId);
		
		 return jdbc.queryForObject("select * from weight where weight.weightId=:weightId", params, new RowMapper<Weight>() {

			@Override
			public Weight mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Weight weight = new Weight();
				weight.setWeightId(rs.getInt("weightId"));
				weight.setUserId(rs.getInt("userId"));
				weight.setUpdateId(rs.getInt("updateId"));
				weight.setWeight(rs.getDouble("weight"));
				weight.setCreateDate(rs.getString("createDate"));
				
				return weight;
			}

		});

	}
	
	public List<Weight> getWeights(int userId) {
		System.out.println("im in here weights");
		
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from weight where weight.userId=:userId", params, new RowMapper<Weight>() {

			@Override
			public Weight mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Weight weight = new Weight();
				System.out.printf("userId = %d\n", rs.getInt("userId"));
				System.out.printf("rowNum = %d\n", rowNum);
				weight.setWeightId(rs.getInt("weightId"));
				weight.setUserId(rs.getInt("userId"));
				weight.setUpdateId(rs.getInt("updateId"));
				weight.setWeight(rs.getDouble("weight"));
				weight.setCreateDate(rs.getString("createDate"));
				return weight;
			}

		});
	}
	
	public boolean updateWeight(Weight weight) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(weight);

		return jdbc.update("update weight set weight=:weight where weightId=:weightId", params) == 1;
	}

	public boolean deleteWeight(int weightId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("weightId", weightId);

		return jdbc.update("delete from weight where weightId=:weightId", params) == 1;
	}
}
