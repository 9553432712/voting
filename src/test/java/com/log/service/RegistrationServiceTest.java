package com.log.service;

import static org.junit.Assert.assertThat;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import com.log.main.AbstractTest;

@Transactional
public class RegistrationServiceTest //extends AbstractTest{
{	
	@Before
	public void setup()
	{
		
	}
	@After
	public void tearDown()
	{
		
	}
	@Test
	public void testRegistrationSubmit()
	{
		Assert.assertTrue(true);
	}
}
