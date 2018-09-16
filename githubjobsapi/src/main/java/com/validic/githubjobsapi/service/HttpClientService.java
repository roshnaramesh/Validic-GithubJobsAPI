/*
 * (c) Copyright 2018 EAB
 */
package com.validic.githubjobsapi.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.validic.githubjobsapi.exception.GithubJobsException;


@Component
public class HttpClientService {

	public Object doGet( String url, Class<?> responseType ) throws GithubJobsException {
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject( url, responseType );
		} catch ( HttpStatusCodeException ex ) {
			throw new GithubJobsException( ex );
		}
	}
}
