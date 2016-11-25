package com.infy.jnana.service;

import java.util.List;

import com.infy.jnana.entity.SearchTag;

public interface SearchService {

public List<String> getTypeAhead(String query)  throws Exception;
	
	public List<SearchTag> getSearchTag();
	
	public void saveTag(String tag);
	
	public void deleteTag(String tag);
	
	
}
