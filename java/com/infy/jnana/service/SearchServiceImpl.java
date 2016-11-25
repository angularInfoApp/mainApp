package com.infy.jnana.service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.jnana.dao.SearchDAO;
import com.infy.jnana.entity.SearchTag;

@Service
public class SearchServiceImpl implements SearchService {	
	
	 private Logger logger = Logger.getLogger(MainServiceImpl.class);
		
		@Autowired
		private SearchDAO searchDAO;
	
	
	public List<String> getTypeAhead(String query) throws Exception {
		
		List<String> typeAhead=new ArrayList<String>();				
		SolrClient solrClients=new HttpSolrClient.Builder("http://localhost:8983/solr/star/").build();
		SolrQuery sq = new SolrQuery();
		sq.setRequestHandler("/suggest");
		sq.set("suggest", true);
		sq.set("suggest.dictionary", "mySuggester");
		sq.set("suggest.q",query);
		sq.setQuery(query);
		QueryResponse rsp = solrClients.query(sq);
		typeAhead=rsp.getSuggesterResponse().getSuggestedTerms().get("mySuggester");
		typeAhead = new ArrayList<String>(new LinkedHashSet<String>(typeAhead));
		System.out.println(typeAhead);
		return typeAhead;
	}


	@Override
	public List<SearchTag> getSearchTag() {

		List<SearchTag> searchTagsList=new ArrayList<SearchTag>();
		searchTagsList=searchDAO.getSearchTag();
		
		
		return searchTagsList;
	}


	@Override
	public void saveTag(String tag) {
		
		searchDAO.saveTag(tag);
	}


	@Override
	public void deleteTag(String tag) {
	
		searchDAO.deleteTag(tag);
		
	}
}
