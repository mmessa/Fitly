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

@Component("ChallengeDAO")
public class ChallengeDao {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Challenge> getChallenges() {

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

	public List<Challenge> getBeginnerChallenges() {

		return jdbc.query("select * from challenge where level=1", new RowMapper<Challenge>() {

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

	public List<Challenge> getIntermediateChallenges() {

		return jdbc.query("select * from challenge where level=2", new RowMapper<Challenge>() {

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
	
	public List<Challenge> getAdvancedChallenges() {

		return jdbc.query("select * from challenge where level=3", new RowMapper<Challenge>() {

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
	
	public List<Challenge> getCompletedChallenges(int userId) {

		MapSqlParameterSource params = new MapSqlParameterSource("userId", userId);
		
		return jdbc.query("select * from performance inner join challenge on performance.challengeId=challenge.challengeId where performance.userId=:userId and performance.complete=1", params, new RowMapper<Challenge>() {
			
			@Override
			public Challenge mapRow(ResultSet rs, int rowNum) throws SQLException {

				Challenge challenge = new Challenge();
				
				System.out.println("here lalalalaalala\n");
				challenge.setChallengeId(rs.getInt("challenge.challengeId"));
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
