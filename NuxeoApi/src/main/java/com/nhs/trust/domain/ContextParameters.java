package com.nhs.trust.domain;
/**
 * @author arif.mohammed
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown=true)
public class ContextParameters {
	
	@JsonProperty("breadcrumb")
	private Breadcrumb breadCrumb;

	public Breadcrumb getBreadCrumb() {
		return breadCrumb;
	}

	public void setBreadCrumb(Breadcrumb breadCrumb) {
		this.breadCrumb = breadCrumb;
	}
	
	

}
