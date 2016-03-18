package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WeightRowMapper implements RowMapper<Weight>{
	@Override
	public Weight mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Weight weight = new Weight();
		weight.setUserId(rs.getInt("userId"));
		weight.setWeight(rs.getDouble("weight"));
		weight.setCreatedAtDate(rs.getDate("createdAtDate"));

		return weight;
	}

}
