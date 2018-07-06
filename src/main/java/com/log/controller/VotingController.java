package com.log.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.log.commondao.CommonDAO;
import com.log.dao.RegistrationDAOImpl;
import com.log.error.CustomizedResponseEntityExceptionHandler;
import com.log.service.VotingService;


@RestController
public class VotingController 
{

	@Autowired
	RegistrationDAOImpl regDAo;
	@Autowired
	CommonDAO cdao;

	@Autowired
	VotingService voteSer;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VotingController.class);
	
	@RequestMapping("/vote")
	public ModelAndView showVotePage()
    {
		LOGGER.info("\n Class VotingController method showVotePage() Entered Mahesh----------------------");
		ModelAndView model = new ModelAndView();
		model.setViewName("vote");
		return model;
    }
	@RequestMapping("/voteSubmit")
	public ModelAndView VoteSubmit(@RequestBody MultiValueMap<String, String> map)
    {
		LOGGER.info("\n Class VotingController method VoteSubmit() Entered Mahesh----------------------");
		return voteSer.insertVote(map);
    }
}
