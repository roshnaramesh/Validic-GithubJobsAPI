/*
 * (c) Copyright Roshna Ramesh
 */
package com.validic.githubjobsapi.domain;

public enum Languages {
	JAVA( "Java" ),
	PYTHON( "Python" ),
	REACT( "React" ),
	RUBY( "Ruby" ),
	NODE( "Node" ),
	SCALA( "Scala" ),
	CPLUSPLUS( "C++" ),
	CSHARP( "C#" ),
	GO( "Go" ),
	JAVASCRIPT( "Javascript" );

	/**
	 * @param typeOfProgrammingLanguage
	 */
	private Languages( String typeOfProgrammingLanguage ) {
		this.typeOfProgrammingLanguage = typeOfProgrammingLanguage;
	}


	private String typeOfProgrammingLanguage;


	/**
	 * @return the typeOfProgrammingLanguage
	 */
	public String getTypeOfProgrammingLanguage() {
		return typeOfProgrammingLanguage;
	}


	/**
	 * @param typeOfProgrammingLanguage the typeOfProgrammingLanguage to set
	 */
	public void setTypeOfProgrammingLanguage( String typeOfProgrammingLanguage ) {
		this.typeOfProgrammingLanguage = typeOfProgrammingLanguage;
	}

}
