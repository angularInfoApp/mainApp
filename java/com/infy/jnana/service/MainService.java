package com.infy.jnana.service;



import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.crypto.NoSuchPaddingException;

import com.infy.jnana.entity.AdminEntity;
import com.infy.jnana.entity.BookmarkEntity;
import com.infy.jnana.entity.LanPathEntity;
import com.infy.jnana.entity.MyFileEntity;
import com.infy.jnana.entity.Star;
import com.infy.jnana.entity.WordCloud;



public interface MainService {
	
	
	public List<MyFileEntity> getData(String name) throws Exception;
	
	public int insertData(Star star);
	
	public List<WordCloud> getWords();
	
	public List<AdminEntity> getAdmin();
	
	public List<AdminEntity> getUsers(String users);
	
	public List<LanPathEntity> getLanPath(String user);
	
	public void deleteLan(String user,String path);
	
	public void saveLan(LanPathEntity entity);
	
	//public void openDoc(String url);
	
	public void saveBookmark(BookmarkEntity bookmarkEntity);
	
	public void removeBookmark(String user_id,String doc_url);
	
	public List<BookmarkEntity> getBookmark(String user);

	public void openDoc(String url) throws NoSuchAlgorithmException, NoSuchPaddingException;
	

	

}
