package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Seo {
	
	//"vrc:seo":{"metadescription":null,"friendlyurl":null,"metakeywords":null},
	
	@JsonProperty("metadescription")
	private String metaDescription;
	
	@JsonProperty("friendlyurl")
	private String friendlyUrl;
	
	@JsonProperty("metakeywords")
	private String metaKeyWords;

	public String getMetaDescription() {
		return metaDescription;
	}

	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}

	public String getFriendlyUrl() {
		return friendlyUrl;
	}

	public void setFriendlyUrl(String friendlyUrl) {
		this.friendlyUrl = friendlyUrl;
	}

	public String getMetaKeyWords() {
		return metaKeyWords;
	}

	public void setMetaKeyWords(String metaKeyWords) {
		this.metaKeyWords = metaKeyWords;
	}

}
