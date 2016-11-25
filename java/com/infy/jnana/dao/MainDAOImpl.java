
package com.infy.jnana.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infy.jnana.entity.AdminEntity;
import com.infy.jnana.entity.BookmarkEntity;
import com.infy.jnana.entity.LanPathEntity;
import com.infy.jnana.entity.Star;
import com.infy.jnana.entity.WordCloud;

@Repository
public class MainDAOImpl implements MainDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int insertData(Star star) {
		
	String user=star.getUserId();
	String doc=star.getDocId();
		 String sql= "insert into rating(user_id,doc_id,rating) SELECT *"
		 				+ " FROM (SELECT ?,?,?) AS tmp WHERE NOT EXISTS "
		 								+ "(select user_id,doc_id from "
		 								+ "rating where user_id='"+user+"' AND doc_id='"+doc+"')";
		 
				int rateCount=jdbcTemplate.update(sql, new Object[]{
						star.getUserId(),star.getDocId(),star.getRating()
				});	
				if(rateCount==1){
					
					return rateCount;
				}else{
					
					return rateCount;
					
				}
				
				
		
	}

	@Override
	public int find(String docName)  {
		try{
		String sql = "select avg(rating) FROM rating where doc_id=? group by doc_id";
		int rating= jdbcTemplate.queryForObject(
				sql, Integer.class, docName);
		
		return rating;
	}catch(EmptyResultDataAccessException accessException){
		
		int rate=0;
		return rate;
	}
		
	}

	@Override
	public int getRating(String docName) {
		
		try {
			
			String sql="select count(user_id) from rating where doc_id=?";
			
			int rating=jdbcTemplate.queryForObject(sql, Integer.class,docName);
			return rating;
		} catch (EmptyResultDataAccessException accessException) {
			int rate=0;
			
			return rate;
		}
		
	}

	@Override
	public void saveKey(String keyWord) {
		
		
		String sql="INSERT INTO wordcloud (key_word) VALUES (?) ON DUPLICATE KEY UPDATE weight = weight + 1";
		
		jdbcTemplate.update(sql, new Object[]{	
				keyWord
		});	
		
	}

	@Override
	public List<WordCloud> getWords() {
		
		String sql="select id,key_word,count(*) as size from wordcloud group by key_word";
		
		List<WordCloud> wordClouds = this.jdbcTemplate.query(sql
				,
				new RowMapper<WordCloud>(){
				public WordCloud mapRow(ResultSet rs, int rowNum) throws SQLException {
					WordCloud cloud = new WordCloud();
					cloud.setId(rs.getInt("id"));
					cloud.setWord(rs.getString("key_word"));
					cloud.setSize(rs.getInt("size"));
				return cloud;
				}
				});
	
		return wordClouds;
	}

	@Override
	public List<AdminEntity> getAdmin() {
		
		String sql="select * from admin";
		List<AdminEntity> adminEntities=this.jdbcTemplate.query(sql,new RowMapper<AdminEntity>(){
			
			public AdminEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				AdminEntity adminEntity=new AdminEntity();
				adminEntity.setSlNo(rs.getInt("slNo"));
				adminEntity.setUserName(rs.getString("userName"));
				adminEntity.setAdminStatus(rs.getInt("adminStatus"));
				return adminEntity;
			}
		});
		
		return adminEntities;
	
	}

	@Override
	public List<AdminEntity> getUsers(String users) {
		
		String sql="select * from admin where userName LIKE ?";
		
		List<AdminEntity> adminEntities=jdbcTemplate.query(sql,new String[]{"%"+users+"%"},new RowMapper<AdminEntity>(){
			public AdminEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				AdminEntity entity=new AdminEntity();
				entity.setSlNo(rs.getInt("slNo"));
				entity.setUserName(rs.getString("userName"));
				entity.setAdminStatus(rs.getInt("adminStatus"));
				
				return entity;
			}
			
		});
		return adminEntities;
	}

	@Override
	public List<LanPathEntity> getLanPath(String user) {
		
		String sql="select * from lanpath where userName=?";
		List<LanPathEntity> lanPathEntities=this.jdbcTemplate.query(sql,new String[]{user},new RowMapper<LanPathEntity>(){
			
			public LanPathEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				LanPathEntity lanPathEntity=new LanPathEntity();
				
				lanPathEntity.setId(rs.getInt("id"));
				lanPathEntity.setUserName(rs.getString("userName"));
				lanPathEntity.setPath(rs.getString("path"));
				
				return lanPathEntity;
			}
		});
		return lanPathEntities;
	}

	@Override
	public void deleteLan(String user,String path) {
		
		String sql="delete from lanpath where userName=? AND path=?";
		
		jdbcTemplate.update(sql, new Object[]{				
				user , path
		});	
		
		
	}

	@Override
	public void saveLan(LanPathEntity entity)  {

		String sql="insert into lanpath (userName,path)values(?,?)";
		
		jdbcTemplate.update(sql, new Object[]{
				
				entity.getUserName(),entity.getPath()
		});	
		
		
	}

	@Override
	public void saveBookmark(BookmarkEntity bookmarkEntity) {

String sql="insert into bookmark (user_id,doc_name,doc_path,status)values(?,?,?,?)";
		
		jdbcTemplate.update(sql, new Object[]{
				
				bookmarkEntity.getUser_id(),bookmarkEntity.getDoc_name(),
				bookmarkEntity.getDoc_url(),bookmarkEntity.getStatus()
				
		});	
		
	}

	@Override
	public void removeBookmark(String user_id, String doc_url) {
		
			String sql="delete from bookmark where user_id=? AND doc_path=?";
			
			jdbcTemplate.update(sql, new Object[]{				
				
					user_id,doc_url
			});	
			
	}

	@Override
	public int getStatus(String user_id, String doc_url) {
	
		try{
			String sql = "select status FROM bookmark where user_id=? and doc_path=? group by doc_path" ;
			int rating= jdbcTemplate.queryForObject(
					sql, Integer.class, user_id,doc_url);
			
			return rating;
			
		}catch(EmptyResultDataAccessException accessException){
			
			int rate=0;
			return rate;
		}
		
		
	}

	@Override
	public List<BookmarkEntity> getBookmark(String user) {
		
		String sql="select * from bookmark where user_id=?";
		List<BookmarkEntity> bookmarkEntities=this.jdbcTemplate.query(sql,new String[]{user},new RowMapper<BookmarkEntity>(){
			
			public BookmarkEntity mapRow(ResultSet rs, int rowNum) throws SQLException{
				
				BookmarkEntity bookmarkEntity=new BookmarkEntity();
				bookmarkEntity.setBook_id(rs.getInt("book_id"));
				bookmarkEntity.setUser_id(rs.getString("user_id"));
				bookmarkEntity.setDoc_name(rs.getString("doc_name"));
				bookmarkEntity.setDoc_url(rs.getString("doc_path"));
				bookmarkEntity.setStatus(rs.getInt("status"));
				
				return bookmarkEntity;
			}
		});
		
		return bookmarkEntities;
	}

	@Override
	public void icmtDoc(String doc_name) {
		
		String sql="INSERT INTO incrdocument (doc_name) VALUES (?) ON DUPLICATE KEY UPDATE count = count + 1";
		
		
		jdbcTemplate.update(sql, new Object[]{	
				doc_name
		});	
		
	}

	
	
}
