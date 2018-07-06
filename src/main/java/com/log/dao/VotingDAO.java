package com.log.dao;

import java.util.HashMap;

public interface VotingDAO {
	public int votingInsert(HashMap data);

	public boolean checkUserExist(String emailId);
	public boolean checkAlreadyVoted(String emailId);
	public String getTextForEmail(String emailId);

}
