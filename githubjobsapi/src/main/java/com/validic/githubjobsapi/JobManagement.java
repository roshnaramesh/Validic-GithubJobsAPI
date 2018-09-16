/*
 * (c) Copyright 2018 EAB
 */
package com.validic.githubjobsapi;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.validic.githubjobsapi.domain.Cities;
import com.validic.githubjobsapi.domain.Jobs;
import com.validic.githubjobsapi.domain.Languages;
import com.validic.githubjobsapi.exception.GithubJobsException;
import com.validic.githubjobsapi.service.GithubRequestHandler;


@Component
public class JobManagement {

	private static String[] listOfLanguages = new String[] { "Java", "Python", "React", "Ruby", "Node", "Scala", "C++", "C#", "Go", "Javascript" };

	@Autowired
	private GithubRequestHandler githubRequestHandler;


	public void run() throws GithubJobsException {
		LongAdder adder = new LongAdder();
		for ( Cities city : Cities.values() ) {
			String cityOfJob = city.getCity().replace( " ", "+" ).trim();
			int numberOfJobsInCity = (int) githubRequestHandler.requestJobsByCity( cityOfJob ).length;
			if ( numberOfJobsInCity == 0 ) {
				break;
			}
			adder.add( numberOfJobsInCity );
			System.out.println( "\n" + city.getCity() + ":" );
			for ( Languages programmingLanguage : Languages.values() ) {
				Jobs[] jobsByCityAndLanguage = (Jobs[]) githubRequestHandler.requestJobsByCityAndLanguage( cityOfJob, programmingLanguage.getTypeOfProgrammingLanguage() );
				if ( jobsByCityAndLanguage.length == 0 )
					break;
				System.out.println( " -" + programmingLanguage.getTypeOfProgrammingLanguage() );
				Map<String, List<Jobs>> decisionsByS = Arrays.stream( jobsByCityAndLanguage )
						.collect( Collectors.groupingBy( x -> x.getType() ) );
				decisionsByS.entrySet().stream().forEach( x -> System.out.println( " --" + x.getKey() + "-->" + asPercent( x.getValue().size(), numberOfJobsInCity ) ) );
			}
		}
		System.out.println( "\nSourced: " + adder.sum() );
	}


	private static String asPercent( int valueByJobType, int totalNumberOfJobsByCity ) {
		return String.format( "%2.2f%%", ( (float) valueByJobType / totalNumberOfJobsByCity * 100 ) );
	}
}
