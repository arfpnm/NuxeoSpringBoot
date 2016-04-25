package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FooterLeftCol {
	
	/***
	 * 
	 "vrc:footerleftcol":{
		"columntitle":null,
		"link3label":"Privacy policy",
		"link1url":null,
		"link2label":"Accessibility",
		"link2url":null,
		"link3url":null,
		"link4url":null,
		"link1label":"Terms of service",
		"link4label":"Jargon buster"
},
	 
	 */
	
	@JsonProperty("columntitle")
	private String columnTitle;
	private String link3label;
	private String link1url;
	public String getColumnTitle() {
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	public String getLink3label() {
		return link3label;
	}
	public void setLink3label(String link3label) {
		this.link3label = link3label;
	}
	public String getLink1url() {
		return link1url;
	}
	public void setLink1url(String link1url) {
		this.link1url = link1url;
	}
	public String getLink2label() {
		return link2label;
	}
	public void setLink2label(String link2label) {
		this.link2label = link2label;
	}
	public String getLink2url() {
		return link2url;
	}
	public void setLink2url(String link2url) {
		this.link2url = link2url;
	}
	public String getLink3url() {
		return link3url;
	}
	public void setLink3url(String link3url) {
		this.link3url = link3url;
	}
	public String getLink4url() {
		return link4url;
	}
	public void setLink4url(String link4url) {
		this.link4url = link4url;
	}
	public String getLink1label() {
		return link1label;
	}
	public void setLink1label(String link1label) {
		this.link1label = link1label;
	}
	public String getLink4label() {
		return link4label;
	}
	public void setLink4label(String link4label) {
		this.link4label = link4label;
	}
	private String link2label;
	private String link2url;
	private String link3url;
	
	private String link4url;
	private String link1label;
	private String link4label;
	
	
}
