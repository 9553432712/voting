package com.log.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.log.commondao.CommonDAO;
import com.log.commondao.CommonDAOImpl;
import com.log.datasource.GetDataSource;
import com.log.util.CommonUtility;

@Component
@RestController 
public class RegistrationDAOImpl implements RegistrationDAO 
{
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	
	
	@Autowired 
	CommonDAO cdao;

	public int registerUser(HashMap<String, String> newUserData)
	{
		CommonDAO comdao = new CommonDAOImpl();
        String sql = "INSERT INTO user \n" + 
        		"(sno, Student_Id, firstname, lastname, email, phone, state_id, district_id, city_id, college_id,role_id,is_final_year,created_date,created_by,is_active) \n" + 
        		"VALUES(?,?,?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
        
        System.out.println(sql+newUserData.get("isfinalyear"));
        System.out.println(jdbcTemplate);
        int isFinalYear = 0;
        if(newUserData.get("isfinalyear")!=null && newUserData.get("isfinalyear").equals("on"))
        {
        	isFinalYear=1;
        }
        
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = 
             new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(dt);
        
         int result = 0;
         result = jdbcTemplate.update(sql,
        		 CommonUtility.generateRandomStr(15),
        		 newUserData.get("student_id"),
        		 newUserData.get("first_name"),
        		 newUserData.get("last_name"),
        		 newUserData.get("email"),
        		 newUserData.get("phone"),
        		 newUserData.get("stateId"),
        		 newUserData.get("districtId"),
        		 newUserData.get("cityId"),
        		 newUserData.get("collegeId"),
        		 "1",
        		 isFinalYear,
        		 currentTime,
        		 newUserData.get("student_id"),
        		 "Y");
         
         if(result ==1)
         {
        	 cdao.sendMSG(newUserData.get("phone"));
        	 cdao.sendMail(newUserData.get("email"));
         }
         
        return result;
    }
	public boolean checkUserExist(String emailId)
	{
		GetDataSource ds = new GetDataSource();
		String sql = String.format("SELECT count(sno) FROM user where email='%s'",emailId);
		List a = new ArrayList();
		List<ArrayList> data = jdbcTemplate.query(sql, new RowMapper<ArrayList>(){
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
		if(data.get(0).toString().equals("[0]"))
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
