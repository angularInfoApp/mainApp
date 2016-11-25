package com.infy.jnana.service;

import java.util.List;

import com.infy.jnana.entity.IncrDocEntity;
import com.infy.jnana.entity.ReportEntity;

public interface ReportService {

	
	public List<ReportEntity> getRatingReport();
	
	public List<IncrDocEntity> getDocReport();
}
