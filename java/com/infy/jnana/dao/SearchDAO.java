package com.infy.jnana.dao;

import java.util.List;

import com.infy.jnana.entity.SearchTag;

public interface SearchDAO {

	
	public List<SearchTag> getSearchTag();
	
	public void saveTag(String tag);
	
	public void deleteTag(String tag);
	
}
