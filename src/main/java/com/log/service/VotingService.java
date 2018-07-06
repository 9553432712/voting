package com.log.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.ModelAndView;

import com.log.commondao.CommonDAO;
import com.log.dao.VotingDAO;
import com.log.util.AjaxResponseBody;
import com.log.util.CommonUtility;
import com.log.util.EMailService;

@Component
public class VotingService{

	VotingDAO voteDao;
	CommonDAO comDAO;
	EMailService emailserv;
	@Autowired
	public VotingService(CommonDAO comDAO, VotingDAO regDao,EMailService emailserv)
	{
		this.comDAO = comDAO;
		this.voteDao = regDao;
		this.emailserv = emailserv;
	}
	public ModelAndView getStates(ModelAndView model)
	{
				model.setViewName("/vote");
				model.addObject("statesList",  comDAO.getStates());
				return model;
	}
	public ModelAndView insertVote(MultiValueMap<String, String> map)
	{
		ModelAndView model = new ModelAndView();
		HashMap<String,String> userData = new HashMap<String,String>(); 
		userData = CommonUtility.convertMultiToRegularMap(map);
		String emailId = userData.get("email");
		if(!voteDao.checkUserExist(emailId))
		{
			model.setViewName("error");
			model.addObject("errorMSG","The user is not registered");
		}
		else if(voteDao.checkAlreadyVoted(emailId))//Check if already voted
		{
			model.setViewName("error");
			model.addObject("errorMSG","Sorry you already voted!!!");
		}
		else
		{
			int result = voteDao.votingInsert(userData);
			if(result == 1)
			{
				//SEND EMAIL
				model.setViewName("success");
				model.addObject("successMSG","Thanks for voting!!! Your vote is valuable for us!!! <br> Please check your mail and verify it by click on the link!!");
				String emailText = voteDao.getTextForEmail(emailId);
				if(emailText!=null && emailText.length()==20)
				{
					System.out.println("aaaaaaaaaa");
					emailserv.sendMail(emailId, emailText);
				}
			}
		}
		
		return model;
	}
}
