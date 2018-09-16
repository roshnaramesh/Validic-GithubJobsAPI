/*
 * (c) Copyright Roshna Ramesh
 */
package com.validic.githubjobsapi.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.validic.githubjobsapi.domain.Jobs;
import com.validic.githubjobsapi.exception.GithubJobsException;


@Component
public class ParseResponseService {

	@Autowired
	private GithubRequestHandler githubRequestHandler;


	public int findTotalNumberOfJobsByCity( LongAdder adder, String city ) throws GithubJobsException {
		int numberOfJobsInCity = (int) githubRequestHandler.requestJobsByCity( city.replace( " ", "+" ).trim() ).length;
		adder.add( numberOfJobsInCity );
		return numberOfJobsInCity;
	}


	public Map<String, List<Jobs>> partitionJobsByLanguageAndType( String city, String type ) throws GithubJobsException {
		Jobs[] jobsByCityAndLanguage = (Jobs[]) githubRequestHandler.requestJobsByCityAndLanguage( city, type );
		return Arrays.stream( jobsByCityAndLanguage )
				.collect( Collectors.groupingBy( x -> x.getType() ) );
	}
}
