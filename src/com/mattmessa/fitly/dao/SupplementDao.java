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

@Component("SupplementDAO")
public class SupplementDao {
	
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	@Transactional
	public boolean create(Supplement supplement) {
		/*
	    SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");      
	    Date currentDate = sdf.parse(sdf.format(new Date()));		
			
	*/
		MapSqlParameterSource params = new MapSqlParameterSource();
	    //BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(profile);
	    
		params.addValue("userId", supplement.getUserId());
		params.addValue("name", supplement.getName());
		
		return jdbc.update("insert into supplement (userId, name) values (:userId, :name)", params) == 1;

		//return jdbc.update("insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (:userId, :firstName, :lastName, NULL, :heightFeet, :heightInches, NULL, NULL, :city, :state, :zipCode, :gym, 0, 0, NULL)", params) == 1;
		                   // insert into profile (userId, firstName, lastName, image, heightFeet, heightInches, DOB, gender, city, state, zipCode, gym, level, experiencePoints, createTime) values (3,         'Matt',     'Messa', NULL,      6,           2,         NULL, NULL, 'chico' , 'ca', 95928, 'wrec', 0, 0, NULL);
	}

	public Supplement getSupplement(int supplementId) {
		
		
		System.out.printf("dao id = %d", supplementId);

		MapSqlParameterSource params = new MapSqlParameterSource("supplementId", supplementId);
		
		 return jdbc.queryForObject("select * from supplement where supplement.supplementId=:supplementId", params, new RowMapper<Supplement>() {

			@Override
			public Supplement mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Supplement supplement = new Supplement();
				supplement.setSupplementId(rs.getInt("supplementId"));
				supplement.setUserId(rs.getInt("userId"));
				supplement.setName(rs.getString("name"));
				
				return supplement;
			}

		});

	}
	
	public List<Supplement> getSupplements(int userId) {
		System.out.println("im in here");
		
		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from supplement where supplement.userId=:userId", params, new RowMapper<Supplement>() {

			@Override
			public Supplement mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Supplement supplement = new Supplement();
				System.out.printf("userId = %d\n", rs.getInt("userId"));
				System.out.printf("rowNum = %d\n", rowNum);
				supplement.setSupplementId(rs.getInt("supplementId"));
				supplement.setUserId(rs.getInt("userId"));
				supplement.setName(rs.getString("name"));
				
				return supplement;
			}

		});
	}
	
	public boolean updateSupplement(Supplement supplement) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(supplement);

		return jdbc.update("update supplement set name=:name where supplementId=:supplementId", params) == 1;
	}
}
