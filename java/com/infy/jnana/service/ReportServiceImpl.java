package com.infy.jnana.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.jnana.dao.ReportDAO;
import com.infy.jnana.entity.IncrDocEntity;
import com.infy.jnana.entity.ReportEntity;

@Service
public class ReportServiceImpl implements ReportService {

	 private Logger logger = Logger.getLogger(ReportServiceImpl.class);
	
	@Autowired
	private ReportDAO reportDAO;
	
	@Override
	public List<ReportEntity> getRatingReport() {
		
		List<ReportEntity> reportEntities=new ArrayList<ReportEntity>();
		
		reportEntities=reportDAO.getRatingReport();
		
		return reportEntities;
	}

	@Override
	public List<IncrDocEntity> getDocReport() {
		
		List<IncrDocEntity> docEntities=new ArrayList<IncrDocEntity>();

		docEntities=reportDAO.getDocReport();
		
		return docEntities;
	}

}
