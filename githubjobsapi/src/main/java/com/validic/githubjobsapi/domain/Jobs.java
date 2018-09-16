/*
 * (c) Copyright 2018 EAB
 */
package com.validic.githubjobsapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class Jobs {

	private String id;

	@JsonProperty( value = "created_at" )
	private String createdAt;

	private String title;

	private String location;

	private String type;

	private String description;

	@JsonProperty( value = "how_to_apply" )
	private String howToApply;

	private String company;

	@JsonProperty( value = "company_url" )
	private String companyUrl;

	@JsonProperty( value = "company_logo" )
	private String companyLogo;

	private String url;
}
