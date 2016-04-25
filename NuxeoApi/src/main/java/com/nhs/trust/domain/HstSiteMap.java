package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HstSiteMap {
	
	@JsonProperty("templatename")
	private String hippoTemplateName;
	
	@JsonProperty("sync")
	private Boolean isSyncRequired;

	public String getHippoTemplateName() {
		return hippoTemplateName;
	}

	public void setHippoTemplateName(String hippoTemplateName) {
		this.hippoTemplateName = hippoTemplateName;
	}

	public Boolean getIsSyncRequired() {
		return isSyncRequired;
	}

	public void setIsSyncRequired(Boolean isSyncRequired) {
		this.isSyncRequired = isSyncRequired;
	}
		
	

}
