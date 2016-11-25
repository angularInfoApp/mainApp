package com.infy.jnana.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.infy.jnana.entity.IncrDocEntity;
import com.infy.jnana.entity.ReportEntity;
import com.infy.jnana.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;

	
	  private Logger logger = Logger.getLogger(ReportController.class);
	 
	
	static{
	    System.out.println("Static init ReportController");

	}
	
	 @RequestMapping(value="/getRatingReport",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	    @ResponseBody
	    public List<ReportEntity> getRatingReport() throws Exception{   
	    	
		 List<ReportEntity> reportEntities=new ArrayList<ReportEntity>();
	    	 
	    	 try{
	    		 reportEntities=reportService.getRatingReport();
	    	 
	    	 }
	    	 catch(Exception exception){
	    		 
	    		 exception.printStackTrace();
	    		 throw new Exception();
	    		 
	    	 }
			return reportEntities;
	    	
	    }
	

	 @RequestMapping(value="/getIncrDocReport",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	    @ResponseBody
	    public List<IncrDocEntity> getIncrDocReport() throws Exception{   
	    	
		 List<IncrDocEntity> docEntities=new ArrayList<IncrDocEntity>();
	    	 
	    	 try{
	    		 docEntities=reportService.getDocReport();
	    	 
	    	 }
	    	 catch(Exception exception){
	    		 
	    		 exception.printStackTrace();
	    		 throw new Exception();
	    		 
	    	 }
			return docEntities;
	    	
	    }
	
}
