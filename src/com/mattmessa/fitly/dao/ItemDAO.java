package com.mattmessa.fitly.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("ItemDAO")
public class ItemDAO {

	private JdbcTemplate jdbc;
	
	@Autowired	
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}

	public List<Item> getItems(){
		
		return jdbc.query("select * from Item", new RowMapper<Item>(){

			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item();
				
				item.setItemId(rs.getInt("userId"));
				item.setPrice(rs.getInt("price"));
				item.setName(rs.getString("name"));
				item.setImageUrl(rs.getString("imageUrl"));

				return item;
			}
			
		});
		
	}
}
