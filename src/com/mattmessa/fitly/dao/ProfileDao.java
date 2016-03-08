package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	    BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public List<Profile> getProfiles() {

		return jdbc.query("select * from profile, users where profile.userId=users.userId", new RowMapper<Profile>() {

			@Override
			public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				User user = new User();
				user.setAuthority(rs.getString("authority"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setEnabled(true);
				
				
				Profile profile = new Profile();
				profile.setUser(user);
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

}
