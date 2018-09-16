package com.validic.githubjobsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.validic.githubjobsapi.exception.GithubJobsException;


@SpringBootApplication
public class Application {

	public static void main( String[] args ) throws GithubJobsException {
		try ( ConfigurableApplicationContext context = SpringApplication.run( Application.class, args ) ) {
			JobManagement jobsManagement = context.getBean( JobManagement.class );
			jobsManagement.run();
		} catch ( Exception e ) {
			throw new GithubJobsException( "Exception occurred while running application.", e );
		}
	}
}
