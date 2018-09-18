/*
 * (c) Copyright Roshna Ramesh
 */
package com.validic.githubjobsapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.validic.githubjobsapi.domain.Jobs;
import com.validic.githubjobsapi.exception.GithubJobsException;


@Component
public class GithubRequestHandler {

	private static final String GITHUB_URL = "https://jobs.github.com/";

	@Autowired
	private HttpClientService httpClientService;


	public Jobs[] requestJobsByCity( String location ) throws GithubJobsException {

		return (Jobs[]) httpClientService.doGet( GITHUB_URL +
				"/positions.json" +
				"?location=" + location,
				Jobs[].class );

	}


	public Jobs[] requestJobsByCityAndLanguage( String location, String s ) throws GithubJobsException {
		return (Jobs[]) httpClientService.doGet( GITHUB_URL +
				"/positions.json" +
				"?location=" + location +
				"&search=" + s,
				Jobs[].class );

	}
}
