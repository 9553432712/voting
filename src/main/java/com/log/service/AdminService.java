package com.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.log.dao.AdminDAO;
import com.log.dao.AdminDAOImpl;

@Service
public class AdminService {
	@Autowired
	AdminDAO addao;
	public boolean checkAdminAccess(String email, String password, String roleId) {
		//AdminDAO addao = new AdminDAOImpl();
		return addao.checkForAdminAccess(email, password, roleId);
	}

	public  List getUserData() {
		//AdminDAO addao = new AdminDAOImpl();
		return addao.getUserData();
	}

}
