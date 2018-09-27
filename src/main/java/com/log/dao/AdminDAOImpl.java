package com.log.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.log.commondao.CommonDAO;
import com.log.datasource.GetDataSource;

@Repository
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	CommonDAO comdao;
	
	@Autowired
	JdbcTemplate jdbcTemplate ;
	
	public List getUserData() {

		GetDataSource ds = new GetDataSource();
		System.out.println("99999999999999999999"+jdbcTemplate);
		final String SELECT = "select sno,Student_Id,firstname,lastname,role_name,email,phone,state_name,district_name,city_name,college_name,is_final_year from userinfo";		
		List a = new ArrayList();
		 
		List<ArrayList> data = jdbcTemplate.query(SELECT, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		//System.out.println("iiiiiiiiiiiiii"+i);
            		temp.add(rs.getString(i));
            	}
                
                return temp;
            }
       });	
		
		System.out.println(data);
		return data;
		
	}

	public boolean checkForAdminAccess(String email, String password, String roleId) {
		
		GetDataSource ds = new GetDataSource();
		System.out.println("99999999999999999999"+jdbcTemplate);
		final String SELECT_BY_ID_QUERY = String.format("SELECT count(sno) from user where email='%s' and password='%s' and role_id='%s' ",email,password,roleId);
		List a = new ArrayList();
		 
		List<ArrayList> data = jdbcTemplate.query(SELECT_BY_ID_QUERY, new RowMapper<ArrayList>(){
            public ArrayList mapRow(ResultSet rs, int rowNum) throws SQLException 
            {
            	ArrayList temp = new ArrayList();
            	ResultSetMetaData rsmt = rs.getMetaData();
            	for(int i=1;i<=rsmt.getColumnCount();i++)
            	{
            		//System.out.println("iiiiiiiiiiiiii"+i);
            		temp.add(rs.getString(i));
            	}
                
                return temp;
            }
       });	
		
		if(data.get(0).toString().equals("[1]"))
		{
			return true;
		}
		return false;
	}

}
