package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("ChallengeDAO")
public class ChallengeDao {

	private JdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
	
	public List<Challenge> getChallenges() {
		System.out.println("im in here challenges");
		
		return jdbc.query("select * from challenge", new RowMapper<Challenge>() {

			@Override
			public Challenge mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Challenge challenge = new Challenge();
				
				challenge.setChallengeId(rs.getInt("challengeId"));
				challenge.setName(rs.getString("name"));
				challenge.setLevel(rs.getInt("level"));
				challenge.setPictureUrl(rs.getString("pictureUrl"));
				challenge.setDescription(rs.getString("description"));
				challenge.setCoinsGiven(rs.getInt("coinsGiven"));
				challenge.setExperienceGiven(rs.getInt("experienceGiven"));
				
				return challenge;
			}

		});
	}
	
	
	
}
