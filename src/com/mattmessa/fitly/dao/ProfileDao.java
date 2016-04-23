package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("ProfileDAO")
public class ProfileDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(Profile profile) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", profile.getUserId());
		
		return jdbc.update("insert into profile (userId) values (:userId)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public Profile getProfile(int userId) {
		
		
		System.out.printf("dao id = %d", userId);

		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		 return jdbc.queryForObject("select * from profile where profile.userId=:userId", params, new RowMapper<Profile>() {

			@Override
			public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Profile profile = new Profile();
				profile.setUserId(rs.getInt("userId"));
				profile.setFirstName(rs.getString("firstName"));
				profile.setLastName(rs.getString("lastName"));
				profile.setHeightFeet(rs.getInt("heightFeet"));
				profile.setHeightInches(rs.getInt("heightInches"));
				profile.setDOB(rs.getDate("DOB"));
				profile.setGender(rs.getString("gender"));
				profile.setCity(rs.getString("city"));
				profile.setState(rs.getString("state"));
				profile.setZipCode(rs.getInt("zipCode"));
				profile.setGym(rs.getString("gym"));
				profile.setLevel(rs.getInt("level"));
				profile.setExperiencePoints(rs.getInt("experiencePoints"));
				profile.setCoins(rs.getInt("coins"));
				
				return profile;
			}

		});

	}
	
	public boolean updateProfile(Profile profile) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);

		return jdbc.update("update profile set firstName=:firstName, lastName=:lastName, heightFeet=:heightFeet, heightInches=:heightInches, gender=:gender, city=:city, state=:state, zipCode=:zipCode, gym=:gym, level=:level, experiencePoints=:experiencePoints, coins=:coins where userId=:userId", params) == 1;
	}
	
}
