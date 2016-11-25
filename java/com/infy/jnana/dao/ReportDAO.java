package com.infy.jnana.dao;

import java.util.List;

import com.infy.jnana.entity.IncrDocEntity;
import com.infy.jnana.entity.ReportEntity;

public interface ReportDAO {

	public List<ReportEntity> getRatingReport();
	
	public List<IncrDocEntity> getDocReport();
	
}
