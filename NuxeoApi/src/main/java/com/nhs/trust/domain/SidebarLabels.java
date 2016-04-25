package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SidebarLabels {
	
	/***
	 * 
	"vrc:sidebarlabels":{
	"websitelisting":"Published documents",
	"supportgroup":"Support and recovery groups",
	"userstories":"User stories",
	"relatedpages":"Pages on the site",
	"heading":"Things That may help",
	"documentslisting":null
	},
	 
	 */
	
	@JsonProperty("websitelisting")
	private String webListings;
	
	@JsonProperty("supportgroup")
	private String supportGroup;
	
	@JsonProperty("userstories")
	private String userStories;
	
	@JsonProperty("relatedpages")
	private String relatedPages;
	
	private String heading;
	
	@JsonProperty("documentslisting")
	private String documentsListing;

	public String getWebListings() {
		return webListings;
	}

	public void setWebListings(String webListings) {
		this.webListings = webListings;
	}

	public String getSupportGroup() {
		return supportGroup;
	}

	public void setSupportGroup(String supportGroup) {
		this.supportGroup = supportGroup;
	}

	public String getUserStories() {
		return userStories;
	}

	public void setUserStories(String userStories) {
		this.userStories = userStories;
	}

	public String getRelatedPages() {
		return relatedPages;
	}

	public void setRelatedPages(String relatedPages) {
		this.relatedPages = relatedPages;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDocumentsListing() {
		return documentsListing;
	}

	public void setDocumentsListing(String documentsListing) {
		this.documentsListing = documentsListing;
	}
		
	
}
