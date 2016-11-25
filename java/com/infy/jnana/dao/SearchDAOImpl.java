package com.infy.jnana.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infy.jnana.entity.SearchTag;

@Repository
public class SearchDAOImpl implements SearchDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<SearchTag> getSearchTag() {

		String sql="select id,key_word,weight from wordcloud LIMIT 5";
		List<SearchTag> searchTagsList =this.jdbcTemplate.query(sql,new RowMapper<SearchTag>(){
			
			public SearchTag mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				SearchTag searchTags=new SearchTag();
				searchTags.setId(rs.getInt("id"));
				searchTags.setSearchTag(rs.getString("key_word"));
				searchTags.setCount(rs.getInt("weight"));
				
				
				return searchTags;
			}
		});
		
		return searchTagsList;
	}
	
	
	@Override
	public void saveTag(String tag) {
		String sql="insert into wordcloud (key_word,weight) values (?,(SELECT MAX(weight)+1 FROM wordcloud words))";
		
		jdbcTemplate.update(sql, new Object[]{	
				tag
		});	
		
	}
	@Override
	public void deleteTag(String tag) {
	
String sql="delete from wordcloud where key_word=?";
		
		jdbcTemplate.update(sql, new Object[]{	
				tag
		});	
		
		
	}
	
}
