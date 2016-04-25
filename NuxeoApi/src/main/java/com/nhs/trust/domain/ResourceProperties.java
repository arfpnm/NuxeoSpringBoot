package com.nhs.trust.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ResourceProperties {

	private String uid;

	@JsonProperty("vrc:imagepath")
	private String imagePath;
	@JsonProperty("vrc:sitename")
	private String siteName;
	@JsonProperty("vrc:logopath")
	private String logoPath;
	@JsonProperty("vrc:url")
	private String url;

	@JsonProperty("dc:description")
	private String description;
	
	@JsonProperty("vrc:subjects")
	private List<String> subjects;
	
	@JsonProperty("vrc:longitude")
	private String logitude;
	
	@JsonProperty("vrc:order")
	private String order;

	@JsonProperty("vrc:footerrightcol")
	private FooterRightCol footerRightCol;
	
	@JsonProperty("vrc:footermidcol")
	private FooterMidCol footerMidCol;
	
	@JsonProperty("vrc:footerleftcol")
	private FooterLeftCol footerLeftCol;
	
	@JsonProperty("vrc:sidebarlabels")
	private SidebarLabels sidebarLabels;
	
	@JsonProperty("vrc:searchresultslabels")
	private SearchResultsLabels searchResultsLabels;
	
	@JsonProperty("vrc:seo")
	private Seo seo;
	
	private String logoImageTitle;
	private String logoPathLink;
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public String getLogitude() {
		return logitude;
	}

	public void setLogitude(String logitude) {
		this.logitude = logitude;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public FooterRightCol getFooterRightCol() {
		return footerRightCol;
	}

	public void setFooterRightCol(FooterRightCol footerRightCol) {
		this.footerRightCol = footerRightCol;
	}

	public FooterMidCol getFooterMidCol() {
		return footerMidCol;
	}

	public void setFooterMidCol(FooterMidCol footerMidCol) {
		this.footerMidCol = footerMidCol;
	}

	public FooterLeftCol getFooterLeftCol() {
		return footerLeftCol;
	}

	public void setFooterLeftCol(FooterLeftCol footerLeftCol) {
		this.footerLeftCol = footerLeftCol;
	}

	public SidebarLabels getSidebarLabels() {
		return sidebarLabels;
	}

	public void setSidebarLabels(SidebarLabels sidebarLabels) {
		this.sidebarLabels = sidebarLabels;
	}
	
	public SearchResultsLabels getSearchResultsLabels() {
		return searchResultsLabels;
	}

	public void setSearchResultsLabels(SearchResultsLabels searchResultsLabels) {
		this.searchResultsLabels = searchResultsLabels;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLogoImageTitle() {
		return logoImageTitle;
	}

	public void setLogoImageTitle(String logoImageTitle) {
		this.logoImageTitle = logoImageTitle;
	}

	public String getLogoPathLink() {
		return logoPathLink;
	}

	public void setLogoPathLink(String logoPathLink) {
		this.logoPathLink = logoPathLink;
	}

	public Seo getSeo() {
		return seo;
	}

	public void setSeo(Seo seo) {
		this.seo = seo;
	}
	
}