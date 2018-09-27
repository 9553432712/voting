package com.log.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.log.commondao.CommonDAO;
import com.log.commondao.CommonDAOImpl;
import com.log.datasource.GetDataSource;

@Component
public class VotingDAOImpl implements VotingDAO {

	@Autowired
	JdbcTemplate jdbcTemplate ;
	@Autowired
	CommonDAO cdao;

	
	@Override
	public int votingInsert(HashMap data) {
		CommonDAO comdao = new CommonDAOImpl();
        String sql = "INSERT INTO voter \n" + 
        		"(student_id,email,vname,created_date, created_by,is_active) \n" + 
        		"VALUES(?,?,?,?,?,?)";
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
         int result = 0;
         result = jdbcTemplate.update(sql,
        		 data.get("student_id"),
        		 data.get("email"),
        		 data.get("vname"),
        		 currentTime,
        		 data.get("student_id"),
        		 "Y"
        		 );
         if(result==1) {System.out.println("00000000000"+cdao);
        	 cdao.sendMail((String) data.get("email"));
        	 
         }
        return result;
	}

	private Timestamp convertJavaDateToSqlDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean checkUserExist(String emailId) {
		GetDataSource ds = new GetDataSource();
		String sql = String.format("SELECT count(sno) FROM user where email=? ");;
		Object[] inputs = new Object[] {emailId};
		String text = jdbcTemplate.queryForObject(sql, inputs, String.class);
		if(text.trim().equals("1"))
		{
			return true;
		}
		return false;
	}
	public boolean checkAlreadyVoted(String emailId) {
		GetDataSource ds = new GetDataSource();
		String sql = String.format("SELECT count(email) FROM voter where email=? ");;
		Object[] inputs = new Object[] {emailId};
		String text = jdbcTemplate.queryForObject(sql, inputs, String.class);
		if(text.trim().equals("0"))
		{
			return false;
		}
		return true;
	}
	public String getTextForEmail(String emailId)
	{
		GetDataSource ds = new GetDataSource();
		String sql = String.format("SELECT text FROM email_log where email=? order by created_date desc limit 1");
		Object[] inputs = new Object[] {emailId};
		String text = jdbcTemplate.queryForObject(sql, inputs, String.class);
		return text;
	}
	

	
}
