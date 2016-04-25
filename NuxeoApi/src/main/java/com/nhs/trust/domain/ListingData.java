package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ListingData {
		
	@JsonProperty("listingtitle")
	private String listingTitle;
	
	@JsonProperty("listingUrl")
	private String listingUrl;
	
	@JsonProperty("listingintroduction")
	private String listingIntroduction;
	
	@JsonProperty("listingheaderimage")
	private String listingHeaderImage;

	public String getListingTitle() {
		return listingTitle;
	}

	public void setListingTitle(String listingTitle) {
		this.listingTitle = listingTitle;
	}

	public String getListingUrl() {
		return listingUrl;
	}

	public void setListingUrl(String listingUrl) {
		this.listingUrl = listingUrl;
	}

	public String getListingIntroduction() {
		return listingIntroduction;
	}

	public void setListingIntroduction(String listingIntroduction) {
		this.listingIntroduction = listingIntroduction;
	}

	public String getListingHeaderImage() {
		return listingHeaderImage;
	}

	public void setListingHeaderImage(String listingHeaderImage) {
		this.listingHeaderImage = listingHeaderImage;
	}
	
	

}
