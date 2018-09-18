/*
 * (c) Copyright Roshna Ramesh
 */
package com.validic.githubjobsapi.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.validic.githubjobsapi.GithubJobsApplication;
import com.validic.githubjobsapi.exception.GithubJobsException;


@RunWith( SpringRunner.class )
@SpringBootTest( classes = { GithubJobsApplication.class } )
public class ParseResponseServiceTest {

	@Autowired
	private ParseResponseService parseResponseService;


	@Test
	public void findTotalNumberOfJobsByCityTest() throws GithubJobsException {
		parseResponseService.findTotalNumberOfJobsByCity( "Boston" );
	}


	@Test
	public void partitionJobsByLanguageAndTypeTest() throws GithubJobsException {
		parseResponseService.partitionJobsByLanguageAndType( "Boston", "Full Time" );
	}
}
