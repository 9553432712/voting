package com.log.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.log.datasource.GetDataSource;

@Repository
public class EmailVerificationDAOImpl implements EmailVerificationDAO {
	@Autowired
	JdbcTemplate jdbcTemplate ;
	public boolean emailIdVerify(String emailTextUniqueId) {
		GetDataSource ds = new GetDataSource();
		String sql = String.format("SELECT count(email) FROM email_log where text=? ");
		Object[] inputs = new Object[] {emailTextUniqueId};
		String text = jdbcTemplate.queryForObject(sql, inputs, String.class);
		
		if(text.trim().equals("1"))
		{
			java.util.Date dt = new java.util.Date();
	        java.text.SimpleDateFormat sdf = 
	             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String currentTime = sdf.format(dt);
	        
			String updateQuery = "update user set email_verify = ?,updated_date=?,updated_by=? where email in (select email from email_log where text=?)";
			jdbcTemplate.update(updateQuery, "Y",currentTime,"Admin", emailTextUniqueId);
			return true;
		}
		return false;
	}

}
