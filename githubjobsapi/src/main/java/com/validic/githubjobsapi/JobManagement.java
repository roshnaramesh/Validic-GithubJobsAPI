/*
 * (c) Copyright Roshna Ramesh
 */
package com.validic.githubjobsapi;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.LongAdder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.validic.githubjobsapi.domain.Cities;
import com.validic.githubjobsapi.domain.Jobs;
import com.validic.githubjobsapi.domain.Languages;
import com.validic.githubjobsapi.exception.GithubJobsException;
import com.validic.githubjobsapi.service.ParseResponseService;


@Component
public class JobManagement {

	@Autowired
	private ParseResponseService parseResponseService;


	public void run() throws GithubJobsException {

		LongAdder adder = new LongAdder();

		for ( Cities city : Cities.values() ) {

			System.out.println( "\n" + city.getCity() + ":" );

			String cityOfJob = city.getCity().replace( " ", "+" );
			int totalNumberOfJobsByCity = parseResponseService.findTotalNumberOfJobsByCity( adder, cityOfJob );

			for ( Languages programmingLanguage : Languages.values() ) {

				System.out.println( " -" + programmingLanguage.getTypeOfProgrammingLanguage() );

				Map<String, List<Jobs>> listOfJobsPartitionedByJobType = parseResponseService.partitionJobsByLanguageAndType( cityOfJob, programmingLanguage.getTypeOfProgrammingLanguage() );

				if ( listOfJobsPartitionedByJobType.size() == 0 )
					System.out.println( " --No Jobs" );
				else
					listOfJobsPartitionedByJobType.entrySet()
							.stream()
							.forEach( jobType -> System.out.println( " --" + jobType.getKey() + "-->" + asPercent( jobType.getValue().size(), totalNumberOfJobsByCity ) ) );
			}
		}

		System.out.println( "\nSourced: " + adder.sum() );
	}


	private static String asPercent( int valueByJobType, int totalNumberOfJobsByCity ) {
		return String.format( "%2.2f%%", ( (float) valueByJobType / totalNumberOfJobsByCity * 100 ) );
	}
}
