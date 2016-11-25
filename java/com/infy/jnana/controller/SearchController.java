package com.infy.jnana.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infy.jnana.entity.SearchTag;
import com.infy.jnana.service.SearchService;


@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	

	
	  private Logger logger = Logger.getLogger(MainController.class);
	 
	
	static{
	    System.out.println("Static init SearchSController");

	}
	
	
	 @RequestMapping(value="/getTypeAhead",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	    @ResponseBody
		public List<String> getTypeAhead(@RequestParam(value="query") String name)  throws Exception {
	    	
			List<String> typeAhead=new ArrayList<String>();	
	    	
	    	try{
	    		
	    		typeAhead=searchService.getTypeAhead(name);
			
	    	}catch(Exception exception){
	    		
	    		logger.error(exception.getMessage());
	    		
	    		throw new Exception();
	    		
	    	}
		
	    	return typeAhead;
			
		} 
	
	  @RequestMapping(value="/getSearchTags",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	    @ResponseBody
	    public List<SearchTag> getSearchTags() throws Exception{   
	    	
			List<SearchTag> searchTagsList=new ArrayList<SearchTag>();
	    	 
	    	 try{
	    		 searchTagsList=searchService.getSearchTag();
	    	 
	    	 }
	    	 catch(Exception exception){
	    		 
	    		 exception.printStackTrace();
	    		 throw new Exception();
	    		 
	    	 }
			return searchTagsList;    	
	    	
	    }
	  
	  @RequestMapping(value="/addTag",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	    @ResponseBody
	    public void addTag(@RequestParam(value="tag") String tag) throws Exception{
	    	
	    	try{
	    		searchService.saveTag(tag);
	    		
	    	}catch(Exception exception){
	    		
	    		exception.printStackTrace();
	    		
	    		throw new Exception();
	    	}
	    }
	  
	  @RequestMapping(value="/removeTag",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	    @ResponseBody
	    public void deleteTag(@RequestParam(value="tag") String tag) throws Exception{
	    	
	    	try{
	    		searchService.deleteTag(tag);
	    		
	    	}catch(Exception exception){
	    		
	    		exception.printStackTrace();
	    		
	    		throw new Exception();
	    	}
	    }
}
