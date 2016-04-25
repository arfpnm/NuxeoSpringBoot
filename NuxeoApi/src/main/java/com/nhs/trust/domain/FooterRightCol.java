package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class FooterRightCol {

	@JsonProperty("columntitle")
	private String columnTitle;
	@JsonProperty("footerimage")
	private String footerImage;
	@JsonProperty("footerstrapline")
	private String footerStrapLine;
	
	
	private String imageLink;
	private String imageTitle;
	
	public String getColumnTitle() {
		return columnTitle;
	}
	public void setColumnTitle(String columnTitle) {
		this.columnTitle = columnTitle;
	}
	public String getFooterImage() {
		return footerImage;
	}
	public void setFooterImage(String footerImage) {
		this.footerImage = footerImage;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	public String getImageTitle() {
		return imageTitle;
	}
	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}
	public String getFooterStrapLine() {
		return footerStrapLine;
	}
	public void setFooterStrapLine(String footerStrapLine) {
		this.footerStrapLine = footerStrapLine;
	}
	
}
