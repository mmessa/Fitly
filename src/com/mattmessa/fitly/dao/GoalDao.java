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

@Component("GoalDAO")
public class GoalDao {
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(Goal goal) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", goal.getUserId());
		params.addValue("name", goal.getName());
		params.addValue("type", goal.getType());
		params.addValue("description", goal.getDescription());
		params.addValue("value", goal.getValue());
		params.addValue("complete", goal.getComplete());
		
		
		return jdbc.update("insert into goal (userId, name, type, value, description, complete) values (:userId, :name, :type, :value, :description, :complete)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public Goal getGoal(int goalId) {
		
		MapSqlParameterSource params = new MapSqlParameterSource("goalId", goalId);
		
		 return jdbc.queryForObject("select * from goal where goal.goalId=:goalId", params, new RowMapper<Goal>() {

			@Override
			public Goal mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Goal goal = new Goal();
				goal.setGoalId(rs.getInt("goalId"));
				goal.setUserId(rs.getInt("userId"));
				goal.setName(rs.getString("name"));
				goal.setType(rs.getInt("type"));
				goal.setDescription(rs.getString("description"));
				goal.setValue(rs.getDouble("value"));
				goal.setComplete(rs.getInt("complete"));

				return goal;
			}

		});

	}
	
	public List<Goal> getGoals(int userId) {
		System.out.println("im in here goals");
		
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from goal where goal.userId=:userId", params, new RowMapper<Goal>() {

			@Override
			public Goal mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Goal goal = new Goal();
				goal.setGoalId(rs.getInt("goalId"));
				goal.setUserId(rs.getInt("userId"));
				goal.setName(rs.getString("name"));
				goal.setType(rs.getInt("type"));
				goal.setDescription(rs.getString("description"));
				goal.setValue(rs.getDouble("value"));
				goal.setComplete(rs.getInt("complete"));
				
				return goal;
			}

		});
	}
	
	public boolean updateGoal(Goal goal) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(goal);

		return jdbc.update("update goal set name=:name, type=:type, description=:description, value=:value, complete=:complete where goalId=:goalId", params) == 1;
	}

	public boolean deleteGoal(int goalId) {
		MapSqlParameterSource params = new MapSqlParameterSource("goalId", goalId);

		return jdbc.update("delete from goal where goalId=:goalId", params) == 1;
	}
}
