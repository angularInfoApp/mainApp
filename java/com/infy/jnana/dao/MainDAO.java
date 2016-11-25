package com.infy.jnana.dao;

import java.util.List;

import com.infy.jnana.entity.AdminEntity;
import com.infy.jnana.entity.BookmarkEntity;
import com.infy.jnana.entity.LanPathEntity;
import com.infy.jnana.entity.Star;
import com.infy.jnana.entity.WordCloud;

public interface MainDAO {

	public int insertData(Star star);
	
	public int find(String docName);
	
	public int getRating(String docName);
	
	public void saveKey(String keyWord);
	
	public List<WordCloud> getWords();
	
	public List<AdminEntity> getAdmin();
	
	public List<AdminEntity> getUsers(String users);
	
	public List<LanPathEntity> getLanPath( String user);
	
	public void deleteLan(String user,String path);
		
	public void saveLan(LanPathEntity entity);
	
	public void saveBookmark(BookmarkEntity bookmarkEntity);
	
	public void removeBookmark(String user_id,String doc_url);
	
	public int getStatus(String user_id,String doc_url);
	
	public List<BookmarkEntity> getBookmark(String user);
	
	public void icmtDoc(String doc_name);
	
	
	
}
