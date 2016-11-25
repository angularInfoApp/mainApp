package com.infy.jnana.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.infy.jnana.entity.IncrDocEntity;
import com.infy.jnana.entity.ReportEntity;


@Repository
public class ReportDAOImpl implements ReportDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<ReportEntity> getRatingReport() {
	
				String sql="select doc_id,rating from rating  order by rating desc limit 10";
				
				List<ReportEntity> reportEntities = this.jdbcTemplate.query(sql
						,
						new RowMapper<ReportEntity>(){
						public ReportEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
							ReportEntity reportEntity = new ReportEntity();
							
							reportEntity.setlabel(rs.getString("doc_id"));
							reportEntity.setvalue(rs.getInt("rating"));
							
						return reportEntity;
						}
						});
			
				return reportEntities;
	}

	@Override
	public List<IncrDocEntity> getDocReport() {

	String sql="select doc_name,count from incrdocument  order by count desc limit 10";
	List<IncrDocEntity> docEntities = this.jdbcTemplate.query(sql
			,
			new RowMapper<IncrDocEntity>(){
			public IncrDocEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
				IncrDocEntity docEntity = new IncrDocEntity();
				
				docEntity.setLabel(rs.getString("doc_name"));
				docEntity.setValue(rs.getInt("count"));
				
			return docEntity;
			}
			});

	return docEntities;
	}

	
	
}
