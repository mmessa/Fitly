package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WeightRowMapper implements RowMapper<Weight>{
	@Override
	public Weight mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Weight weight = new Weight();
		System.out.printf("userId = %d\n", rs.getInt("userId"));
		System.out.printf("rowNum = %d\n", rowNum);
		weight.setUserId(rs.getInt("userId"));
		weight.setWeight(rs.getDouble("weight"));
		weight.setCreateDate(rs.getString("createDate"));

		return weight;
	}

}
