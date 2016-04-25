package com.nhs.trust.domain;
/**
 * @author arif.mohammed
 */
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Properties {

	@JsonProperty("dc:creator")
	private String creator;

	@JsonProperty("dc:description")
	private String description;

	@JsonProperty("file:content")
	private FileContents fileContents;

	@JsonProperty("note:note")
	private String note;

	@JsonProperty("dc:source")
	private String source;

	@JsonProperty("nhstrust:headerimage")
	private String headerimage;
	
	@JsonProperty("nhstrust:trustinfo")
	private List<String> trustinfo;
	
	@JsonProperty("nhstrust:recruitment")
	private List<String> recruitment;
	
	@JsonProperty("nhstrust:getinvolved")
	private List<String> getInvolved;
	
	@JsonProperty("nhstrust:referrer")
	private List<String> referrer;
	
	@JsonProperty("nhstrust:featured")
	private String featured;
	
	@JsonProperty("nhstrust:hospitals")
	private List<String> hospitals;
	
	@JsonProperty("nhstrust:relateddocuments")
	private List<String> relateddocuments;
	
	@JsonProperty("nhstrust:phone")
	private String phone;
	
	@JsonProperty("nhstrust:lazyloading")
	private String lazyloading;
	
	@JsonProperty("nhstrust:documenttype")
	private String documentType;

	@JsonProperty("nhstrust:address")
	private Address address;

	@JsonProperty("nhstrust:moreinformation")
	private List<String> moreInformationList;
	
	@JsonProperty("nhstrust:services")
	private List<String> services;
	
	@JsonProperty("vrc:subjects")
	private List<String> subjectTags;
	
	@JsonProperty("vrc:url")
	private String resourceUrl;
	
	@JsonProperty("vrc:videoId")
	private String videoId;
	
	@JsonProperty("vrc:videotype")
	private String videoType;
	
	@JsonProperty("nhstrust:header")
	private Header header;
	
//	@JsonProperty("nhstrust:listingimage")
//	private ListingImage listingImage;
	
	@JsonProperty("nhstrust:hstsitemap")
	private HstSiteMap hstSiteMap;
	
	@JsonProperty("nhstrust:cqc")
	private String cqc;
		
	@JsonProperty("nhstrust:listingdata")
	private List<ListingData> listingData;
	
	@JsonProperty("nhstrust:listingimage")
	private String listingImageId;
	
	/** Test header2 for banner TODO: to be removed**/
	@JsonProperty("nhstrust:header2")
	private List<String> header2;
	
	@JsonProperty("vrc:hidefromnav")
	private boolean isHiddenForNavigation;
	 
	@JsonProperty("vrc:order")
	private Long order;
	
	@JsonProperty("vrc:featuredimage")
	private String featureImageId;
	
	@JsonProperty("vrc:template")
	private String template;
	
	//VRC
	@JsonProperty("vrc:seo")
	private Seo seo;
	
	@JsonProperty("vrc:linktype")
	private String linkType;
	
	@JsonProperty("vrc:buttontext")
	private String buttonText;
		
	/**
	 "vrc:footerrightcol":
	 {
	 "columntitle":"Designed and built by",
	 "footerimage":null
	 }
	 
	 */
	//@JsonProperty("vrc:footerrightcol")
	private Map<String, String> footerRightColMap;

	public List<String> getHeader2() {
		return header2;
	}
	public void setHeader2(List<String> header2) {
		this.header2 = header2;
	}
	/**
	 
	 "nhstrust:listingdata":
	 [
		 {"listingtitle":"Locations And Contacts","listingUrl":"locations-and-contacts","listingintroduction":""},
		 {"listingtitle":"Care And Treatment","listingUrl":"care-and-treatment","listingintroduction":"Select the location you wish to find the service in"
		 }
	 ],
	 
	  *
	  */
	
	
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public FileContents getFileContents() {
		return fileContents;
	}
	public void setFileContents(FileContents fileContents) {
		this.fileContents = fileContents;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getHeaderimage() {
		return headerimage;
	}
	public void setHeaderimage(String headerimage) {
		this.headerimage = headerimage;
	}
	public List<String> getTrustinfo() {
		return trustinfo;
	}
	public void setTrustinfo(List<String> trustinfo) {
		this.trustinfo = trustinfo;
	}
	public String getFeatured() {
		return featured;
	}
	public void setFeatured(String featured) {
		this.featured = featured;
	}
//	public String getListingimage() {
//		return listingimage;
//	}
//	public void setListingimage(String listingimage) {
//		this.listingimage = listingimage;
//	}
	public List<String> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<String> hospitals) {
		this.hospitals = hospitals;
	}
	public List<String> getRelateddocuments() {
		return relateddocuments;
	}
	public void setRelateddocuments(List<String> relateddocuments) {
		this.relateddocuments = relateddocuments;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLazyloading() {
		return lazyloading;
	}
	public void setLazyloading(String lazyloading) {
		this.lazyloading = lazyloading;
	}
	public String getDocumenttype() {
		return documentType;
	}
	public void setDocumenttype(String documentType) {
		this.documentType = documentType;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public List<String> getMoreInformationList() {
		return moreInformationList;
	}
	public void setMoreInformationList(List<String> moreInformationList) {
		this.moreInformationList = moreInformationList;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
//	public ListingImage getListingImage() {
//		return listingImage;
//	}
//	public void setListingImage(ListingImage listingImage) {
//		this.listingImage = listingImage;
//	}
	public HstSiteMap getHstSiteMap() {
		return hstSiteMap;
	}
	public void setHstSiteMap(HstSiteMap hstSiteMap) {
		this.hstSiteMap = hstSiteMap;
	}
	public String getCqc() {
		return cqc;
	}
	public void setCqc(String cqc) {
		this.cqc = cqc;
	}
	public List<ListingData> getListingData() {
		return listingData;
	}
	public void setListingData(List<ListingData> listingData) {
		this.listingData = listingData;
	}
	public List<String> getRecruitment() {
		return recruitment;
	}
	public void setRecruitment(List<String> recruitment) {
		this.recruitment = recruitment;
	}
	public List<String> getGetInvolved() {
		return getInvolved;
	}
	public void setGetInvolved(List<String> getInvolved) {
		this.getInvolved = getInvolved;
	}
	public List<String> getReferrer() {
		return referrer;
	}
	public void setReferrer(List<String> referrer) {
		this.referrer = referrer;
	}
	public String getListingImageId() {
		return listingImageId;
	}
	public void setListingImageId(String listingImageId) {
		this.listingImageId = listingImageId;
	}
	public List<String> getSubjectTags() {
		return subjectTags;
	}
	public void setSubjectTags(List<String> subjectTags) {
		this.subjectTags = subjectTags;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public Map<String, String> getFooterRightColMap() {
		return footerRightColMap;
	}
	public void setFooterRightColMap(
			Map<String, String> footerRightColMap) {
		this.footerRightColMap = footerRightColMap;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public boolean isHiddenForNavigation() {
		return isHiddenForNavigation;
	}
	public void setHiddenForNavigation(boolean isHiddenForNavigation) {
		this.isHiddenForNavigation = isHiddenForNavigation;
	}
	public Long getOrder() {
		return order;
	}
	public void setOrder(Long order) {
		this.order = order;
	}
	public String getFeatureImageId() {
		return featureImageId;
	}
	public void setFeatureImageId(String featureImageId) {
		this.featureImageId = featureImageId;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public Seo getSeo() {
		return seo;
	}
	public void setSeo(Seo seo) {
		this.seo = seo;
	}
	public String getLinkType() {
		return linkType;
	}
	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}
	public String getButtonText() {
		return buttonText;
	}
	public void setButtonText(String buttonText) {
		this.buttonText = buttonText;
	}

}
