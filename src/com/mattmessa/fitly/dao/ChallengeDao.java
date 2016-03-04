package com.mattmessa.fitly.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("ChallengeDAO")
public class ChallengeDao {

	private JdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}
}
