package com.log.util;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.log.commondao.CommonDAO;

@Controller
public class AjaxEndPoints 
{
	CommonDAO cdao;
	@Autowired
	AjaxEndPoints(CommonDAO cdao)
	{
		this.cdao = cdao;
	}
	
	
	@RequestMapping(value="/getState", method = RequestMethod.POST)
	public ResponseEntity<?> getStates(HttpServletRequest req)//@RequestBody MultiValueMap<String, String> map)
	{
		System.out.println("--------------------getState");
		String mandalListCombo="";
		
		AjaxResponseBody result = new AjaxResponseBody();
		
		ArrayList stateList = (ArrayList) cdao.getStates();
		
		mandalListCombo =CommonUtility.createStrComboBoxAuto("stateId",stateList,"","fa fa-lock fa-lg","",true,true,"");
		
		System.out.println(mandalListCombo);
		
		result.setResultList(cdao.getStates());
		result.setResultMSG(mandalListCombo);
		
		return ResponseEntity.ok(result);
		
	}
	@RequestMapping(value="/getDistrict", method = RequestMethod.POST)
	public ResponseEntity<?> getDistrictList(HttpServletRequest req)
	{
		String mandalListCombo="";
		//System.out.println("@@@@@@@@@@@@@mahesh@@@@@"+req.getParameter("stateId"));
		AjaxResponseBody result = new AjaxResponseBody();
		System.out.println("0000000000000000");
		
		//CommonDAO comDAO = new CommonDAOImpl();
		//System.out.println("0000000000000000");
		
		
		String StateId = req.getParameter("stateId");
		ArrayList stateList = (ArrayList) cdao.getDistricts( StateId);
		
		mandalListCombo =CommonUtility.createStrComboBoxAuto("districtId",stateList,"","fa fa-lock fa-lg","",true,true,"");
		
		System.out.println(mandalListCombo);
		
		//result.setResultList(cdao.getStates());
		//result.setResultMSG(mandalListCombo);
		
		return ResponseEntity.ok(mandalListCombo);
		
	}
	@RequestMapping(value="/getCity", method = RequestMethod.POST)
	public ResponseEntity<?> getCityList(HttpServletRequest req)
	{
		String cityListCombo="";
		AjaxResponseBody result = new AjaxResponseBody();
		
		String StateId = req.getParameter("stateId");
		String districtId = req.getParameter("districtId");
		System.out.println(districtId+"StateId   distctId  "+StateId);
		
		ArrayList cityList = (ArrayList) cdao.getCities( StateId, districtId);
		
		cityListCombo =CommonUtility.createStrComboBoxAuto("cityId",cityList,"","fa fa-lock fa-lg","",true,true,"");
		
		System.out.println(cityListCombo);
		
		result.setResultList(cdao.getStates());
		result.setResultMSG(cityListCombo);
		
		return ResponseEntity.ok(cityListCombo);
		
	}
	@RequestMapping(value="/getCollege", method = RequestMethod.POST)
	public ResponseEntity<?> getCollegeList(HttpServletRequest req)
	{
		String cityListCombo="";
		AjaxResponseBody result = new AjaxResponseBody();
		
		String StateId = req.getParameter("stateId");
		String districtId = req.getParameter("districtId");
		String cityId = req.getParameter("cityId");
		System.out.println(districtId+"StateId   distctId  "+StateId);
		
		ArrayList collegeList = (ArrayList) cdao.getColleges( StateId, districtId, cityId);
		
		cityListCombo =CommonUtility.createStrComboBoxAuto("collegeId",collegeList,"","fa fa-lock fa-lg","",true,true,"");
		
		System.out.println(cityListCombo);
		
		result.setResultList(cdao.getStates());
		result.setResultMSG(cityListCombo);
		
		return ResponseEntity.ok(cityListCombo);
		
	}
	

}
