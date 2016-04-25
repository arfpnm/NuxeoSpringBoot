package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SearchResultsLabels {


	/**
	 * 
	 "vrc:searchresultslabels":{
		"userstories":"User stories",
		"documents":"Documents",
		"heading":null,
		"htmlpages":"Pages",
		"websitesonlinelinks":
		"Websites and Online Links",
		"supportgroups":"Support and recovery groups"
	},
	"vrc:imagepath":null,
	"vrc:sitename":"ARCH Online recovery college",
	"vrc:logopath":"logopath",
	"vrc:url":null,
	 
	 
	 */
	
	@JsonProperty("userstories")
	private String userStories;
	private String documents;
	private String heading;
	@JsonProperty("htmlpages")
	private String htmlPages;
	@JsonProperty("websitesonlinelinks")
	private String websitesOnlineLinks;
	@JsonProperty("supportgroups")
	private String supportGroups;
	public String getUserStories() {
		return userStories;
	}
	public void setUserStories(String userStories) {
		this.userStories = userStories;
	}
	public String getDocuments() {
		return documents;
	}
	public void setDocuments(String documents) {
		this.documents = documents;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getHtmlPages() {
		return htmlPages;
	}
	public void setHtmlPages(String htmlPages) {
		this.htmlPages = htmlPages;
	}
	public String getWebsitesOnlineLinks() {
		return websitesOnlineLinks;
	}
	public void setWebsitesOnlineLinks(String websitesOnlineLinks) {
		this.websitesOnlineLinks = websitesOnlineLinks;
	}
	public String getSupportGroups() {
		return supportGroups;
	}
	public void setSupportGroups(String supportGroups) {
		this.supportGroups = supportGroups;
	}


}
