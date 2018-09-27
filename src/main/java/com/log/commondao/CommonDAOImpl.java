package com.log.commondao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.log.beans.User;
import com.log.datasource.GetDataSource;
import com.log.util.CommonUtility;

@Component
@RestController
@Repository
public class CommonDAOImpl implements CommonDAO
{
	@Autowired
	JdbcTemplate jdbc;
	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public List getStates() 
	{
		GetDataSource ds = new GetDataSource();
		String sql = "SELECT state_id,state_name FROM state_master";
		List a = new ArrayList();
		List<ArrayList> data = jdbc.query(sql, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		temp.add(rs.getString(i));
            	}
                return temp;
            }
       });	
		return data;
	}
	public List getDistricts(String stateId) 
	{
		GetDataSource ds = new GetDataSource();
		String sql = "SELECT district_id, district_name FROM district_master where state_id="+stateId;
		List a = new ArrayList();
		List<ArrayList> data = jdbc.query(sql, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		temp.add(rs.getString(i));
            	}
                return temp;
            }
       });	
		return data;
	}
	public List getCities(String stateId, String districtId)
	{
		GetDataSource ds = new GetDataSource();
		String sql = "SELECT city_id, city_name FROM city_master where state_id="+stateId+" and district_id="+districtId;
		List a = new ArrayList();
		List<ArrayList> data = jdbc.query(sql, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		temp.add(rs.getString(i));
            	}
                return temp;
            }
       });	
		return data;
	}
	public List getColleges(String stateId, String districtId, String cityId)
	{
		String sql = "SELECT college_id, college_name FROM college_master where state_id="+stateId+" and district_id="+districtId+" and city_id="+cityId;
		List a = new ArrayList();
		List<ArrayList> data = jdbc.query(sql, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		temp.add(rs.getString(i));
            	}
                return temp;
            }
       });	
		return data;
	}
	public String generateUserID()
	{
		String datetime="";
		for (int i = 0; i < 50; i++) 
		{
	        Date dNow = new Date();
	        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
	        datetime = ft.format(dNow);
		}
		return datetime;
	}
	public void sendMSG(String phone) 
	{
		int randpm = CommonUtility.generateRandomNo(4);
		String sql = "INSERT INTO sms_log \n" + 
        		"(phone , text , is_sent, created_date,created_by,is_active ) \n" + 
        		"VALUES(?,?, ?,?,?,?)";
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
		
		
		jdbc.update(sql,
       		 phone,
       		 randpm,
       		 "N",
       		 currentTime,
       		 "Admin",
       		 "Y");
	}
	public void sendMail(String email)
	{
		String randpm = CommonUtility.generateRandomStr(20);
		String sql = "INSERT INTO email_log \n" + 
        		"(email , text , is_sent , created_date,created_by,is_active) \n" + 
        		"VALUES(?,?, ?,?,?,?)";
		
		java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
		
		jdbc.update(sql,
       		 email,
       		 randpm,
       		 "Y",
       		currentTime,
       		"Admin",
       		"Y");
	}
	public ArrayList getUserData() 
	{
		ArrayList users = new ArrayList<User>();
		final String SELECT_BY_ID_QUERY = "select SNo ,Student_Id , firstname ,lastname ,role_id , \n" + 
				"email , phone ,state_id , district_id ,\n" + 
				"city_id ,college_id ,is_final_year ,phn_verify , email_verify from user";
		users = (ArrayList) namedJdbcTemplate.query(SELECT_BY_ID_QUERY, new com.log.mapping.UserMapper());
		return users;
	}
	
	

}
