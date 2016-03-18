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
		
		return jdbc.update("insert into weight (userId) values (:userId)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public Weight getWeight(int userId) {
		
		
		System.out.printf("dao id = %d", userId);

		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		 return jdbc.queryForObject("select * from weight where weight.userId=:userId", params, new RowMapper<Weight>() {

			@Override
			public Weight mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Weight weight = new Weight();
				weight.setUserId(rs.getInt("userId"));
				weight.setWeight(rs.getDouble("weight"));
				weight.setCreatedAtDate(rs.getDate("createdAtDate"));
				
				return weight;
			}

		});

	}
	
	public List<Weight> getWeights(int userId) {

		return jdbc.query("select * from weight where weight.userId=:userId",
						new MapSqlParameterSource("userId", userId), new WeightRowMapper());
	}
	
	public boolean updateWeight(Weight weight) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(weight);

		return jdbc.update("update weight set weight=:weight where userId=:userId", params) == 1;
	}
}
