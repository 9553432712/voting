package com.log.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.log.beans.User;

public class UserMapper implements RowMapper<User> 
{
        public User mapRow(ResultSet rs, int rowNum) throws SQLException
        {
        	User emp = new User();
        	emp.setSNo(rs.getString("SNo"));
        	emp.setStudent_Id(rs.getString("Student_Id"));
        	emp.setFirstname(rs.getString("firstname"));
        	emp.setLastname(rs.getString("lastname"));
        	emp.setRole_id(rs.getInt("role_id"));
        	emp.setEmail(rs.getString("email"));
        	emp.setPhone(rs.getString("phone"));
        	emp.setState_id(rs.getInt("state_id"));
        	emp.setDistrict_id(rs.getInt("district_id"));
        	emp.setCity_id(rs.getInt("city_id"));
        	emp.setCollege_id(rs.getInt("college_id"));
        	emp.setIs_final_year(rs.getString("is_final_year"));
        	emp.setPhn_verify(rs.getString("phn_verify"));
        	emp.setEmail_verify(rs.getString("email_verify"));
        	
        	//System.out.println("USER IS\n"+emp);
            return emp;
        }
    }