package com.nhs.trust.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Breadcrumb {
	
	@JsonProperty("entity-type")
	private String entityType;
	
	@JsonProperty("entries")
	private List<Document> entries;

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public List<Document> getEntries() {
		return entries;
	}

	public void setEntries(List<Document> entries) {
		this.entries = entries;
	}

	
	
	
}
