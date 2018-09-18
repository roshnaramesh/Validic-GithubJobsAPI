/*
 * (c) Copyright Roshna Ramesh
 */
package com.validic.githubjobsapi.domain;


public enum Cities {
	BOSTON( "Boston" ),
	SFO( "San Francisco" ),
	LA( "Los Angeles" ),
	DENVER( "Denver" ),
	BOULDER( "Boulder" ),
	CHICAGO( "Chicago" ),
	NY( "New York" );


	/**
	 * @param city
	 */
	private Cities( String city ) {
		this.city = city;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity( String city ) {
		this.city = city;
	}

	private String city;
}
