package com.validic.githubjobsapi.exception;


public class GithubJobsException extends Exception {

	private static final long serialVersionUID = 1L;


	public GithubJobsException( String message ) {
		super( message );
	}


	public GithubJobsException( Throwable e ) {
		super( e );
	}


	public GithubJobsException( String message, Throwable e ) {
		super( message, e );
	}
}
