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

@Component("UpdateDAO")
public class UpdateDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(Update update) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", update.getUserId());
		params.addValue("notes", update.getNotes());
		
		return jdbc.update("insert into updates (userId, notes) values (:userId, :notes)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public Update getUpdate(int updateId) {
		
		
		System.out.printf("dao id = %d", updateId);

		MapSqlParameterSource params = new MapSqlParameterSource("updateId", updateId);
		
		 return jdbc.queryForObject("select * from updates where updates.updateId=:updateId", params, new RowMapper<Update>() {

			@Override
			public Update mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Update update = new Update();
				update.setUpdateId(rs.getInt("updateId"));
				update.setUserId(rs.getInt("userId"));
				update.setNotes(rs.getString("notes"));
				update.setCreateDate(rs.getString("createDate"));
				
				return update;
			}

		});

	}
	
	public List<Update> getUpdates(int userId) {
		System.out.println("im in here updates");
		
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from updates where updates.userId=:userId", params, new RowMapper<Update>() {

			@Override
			public Update mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Update update = new Update();
				System.out.printf("userId = %d\n", rs.getInt("userId"));
				System.out.printf("rowNum = %d\n", rowNum);
				update.setUpdateId(rs.getInt("updateId"));
				update.setUserId(rs.getInt("userId"));
				update.setNotes(rs.getString("notes"));
				update.setCreateDate(rs.getString("createDate"));
				
				return update;
			}

		});
	}
	
	public boolean updateUpdate(Update update) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(update);

		return jdbc.update("update updates set notes=:notes where updateId=:updateId", params) == 1;
	}
}
