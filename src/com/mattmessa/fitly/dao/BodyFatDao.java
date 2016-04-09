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

@Component("BodyFatDAO")
public class BodyFatDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public boolean create(BodyFat bodyFat) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", bodyFat.getUserId());
		//params.addValue("createDate", bodyFat.getCreateDate());
		params.addValue("bodyFatPercentage", bodyFat.getBodyFatPercentage());
		
		return jdbc.update("insert into bodyFat (userId, bodyFatPercentage) values (:userId, :bodyFatPercentage)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public BodyFat getBodyFat(int bodyFatId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("bodyFatId", bodyFatId);
		
		 return jdbc.queryForObject("select * from bodyFat where bodyFat.bodyFatId=:bodyFatId", params, new RowMapper<BodyFat>() {

			@Override
			public BodyFat mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BodyFat bodyFat = new BodyFat();
				bodyFat.setBodyFatId(rs.getInt("bodyFatId"));
				bodyFat.setUserId(rs.getInt("userId"));
				bodyFat.setCreateDate(rs.getString("createDate"));
				bodyFat.setBodyFatPercentage(rs.getDouble("bodyFatPercentage"));

				return bodyFat;
			}

		});

	}
	
	public List<BodyFat> getBodyFats(int userId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from bodyFat where bodyFat.userId=:userId", params, new RowMapper<BodyFat>() {

			@Override
			public BodyFat mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				BodyFat bodyFat = new BodyFat();
				bodyFat.setBodyFatId(rs.getInt("bodyFatId"));
				bodyFat.setUserId(rs.getInt("userId"));
				bodyFat.setCreateDate(rs.getString("createDate"));
				bodyFat.setBodyFatPercentage(rs.getDouble("bodyFatPercentage"));
				
				return bodyFat;
			}

		});
	}
	
	public boolean updateBodyFat(BodyFat bodyFat) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(bodyFat);

		return jdbc.update("update bodyFat set bodyFatPercentage=:bodyFatPercentage where bodyFatId=:bodyFatId", params) == 1;
	}
	
	public boolean deleteBodyFat(int bodyFatId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("bodyFatId", bodyFatId);

		return jdbc.update("delete from bodyFat where bodyFatId=:bodyFatId", params) == 1;
	}
	
}
