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

@Component("UserDao")
public class UserDao {
	
	private NamedParameterJdbcTemplate jdbc;
		
	@Autowired	
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean create(User user) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		
		jdbc.update("insert into users (username, email, password, enabled) values (:username, :email, :password, :enabled)", params);
		
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
	}
	
	public List<User> getUsers(){
		
		return jdbc.query("select * from User", new RowMapper<User>(){

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				
				
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				
				return user;
			}
			
		});
	
	}

	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from users where username=:username", 
				new MapSqlParameterSource("username", username), Integer.class) > 0; 
		
	}
	
}