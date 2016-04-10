package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("PerformanceDAO")
public class PerformanceDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(Performance performance) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", performance.getUserId());
		params.addValue("challengeId", performance.getChallengeId());
		
		
		return jdbc.update("insert into performance (userId, challengeId) values (:userId, :challengeId)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}
	
	public List<Performance> getPerformances(int userId) {
		System.out.println("im in here performances");
		
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from performance inner join challenge on performance.challengeId=challenge.challengeId where performance.userId=:userId", params, new RowMapper<Performance>() {

			@Override
			public Performance mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("im in here map row");

				Performance performance = new Performance();
				
				performance.setPerformanceId(rs.getInt("performanceId"));
				performance.setUserId(rs.getInt("userId"));
				performance.setChallengeId(rs.getInt("challengeId"));
				performance.setStartedDate(rs.getString("startedDate"));
				performance.setCompletedDate(rs.getString("completedDate"));
				performance.setComplete(rs.getInt("complete"));
				System.out.println("im in here map row 2");
				performance.setName(rs.getString("name"));
				performance.setLevel(rs.getInt("level"));
				performance.setPictureUrl(rs.getString("pictureUrl"));
				performance.setDescription(rs.getString("description"));
				performance.setCoinsGiven(rs.getInt("coinsGiven"));
				performance.setExperienceGiven(rs.getInt("experienceGiven"));
				performance.setType(rs.getInt("type"));
			
				return performance;
			}

		});
	}
	
	public boolean completePerformance(int performanceId) {
		MapSqlParameterSource params = new MapSqlParameterSource("performanceId", performanceId);

		return jdbc.update("update performance set completedDate=current_timestamp, completed=1 where performanceId=:performanceId", params) == 1;
	}

	public boolean deletePerformance(int performanceId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("performanceId", performanceId);

		return jdbc.update("delete from performance where performanceId=:performanceId", params) == 1;
	}
}
