package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("ProfileDAO")
public class ProfileDao {

	private JdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}

	public List<Profile> getProfiles() {

		return jdbc.query("select * from Profile", new RowMapper<Profile>() {

			@Override
			public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
				Profile profile = new Profile();

				profile.setUserId(rs.getInt("userId"));
				profile.setFirstName(rs.getString("firstName"));
				profile.setLastName(rs.getString("lastName"));

				return profile;
			}

		});

	}

}
