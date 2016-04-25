package com.nhs.trust.domain;
/**
 * @author arif.mohammed
 */
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Document {

	@JsonProperty("entity-type")
	private String entityType;
	private String repository;
	private String uid;
	private String path;
	private String type;
	private String state;
	private String parentRef;
	private String versionLabel;
	private String isCheckedOut;
	private String title;
	private Date lastModified;
	private String[] facets;
	private String changeToken;
	private boolean isFolder;

	
	@JsonProperty("properties")
	Properties properties;
	
	private ContextParameters contextParameters;
	
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
	public String getRepository() {
		return repository;
	}
	public void setRepository(String repository) {
		this.repository = repository;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getParentRef() {
		return parentRef;
	}
	public void setParentRef(String parentRef) {
		this.parentRef = parentRef;
	}
	public String getVersionLabel() {
		return versionLabel;
	}
	public void setVersionLabel(String versionLabel) {
		this.versionLabel = versionLabel;
	}
	public String getIsCheckedOut() {
		return isCheckedOut;
	}
	public void setIsCheckedOut(String isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public String[] getFacets() {
		return facets;
	}
	public void setFacets(String[] facets) {
		this.facets = facets;
	}
	public String getChangeToken() {
		return changeToken;
	}
	public void setChangeToken(String changeToken) {
		this.changeToken = changeToken;
	}
	public Properties getProperties() {
		return properties;
	}
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	public ContextParameters getContextParameters() {
		return contextParameters;
	}
	public void setContextParameters(ContextParameters contextParameters) {
		this.contextParameters = contextParameters;
	}
	public boolean isFolder() {
		return isFolder;
	}
	public void setFolder(boolean isFolder) {
		this.isFolder = isFolder;
	}
	
	/*** JSON
<200 OK,

{"entity-type":"document",
"repository":"default",
"uid":"d7594554-7203-4153-a812-2671d7318d1f",
"path":"/default-domain/sections/arfpnm/NFile",
"type":"File",
"state":"project",
"parentRef":"e705b714-74d5-41bd-9f27-57d98084281a",
"versionLabel":"0.1","isCheckedOut":false,"title":"NFile",
"lastModified":"2015-03-11T14:12:46.44Z",

"properties":{"uid:uid":null,
"uid:minor_version":1,
"uid:major_version":0,
"dc:creator":"Administrator",
"dc:source":"",
"dc:nature":"",
"dc:contributors":["Administrator"],
"dc:created":"2015-03-11T14:11:58.67Z",
"dc:description":"Nuxeo file",
"dc:rights":"",
"dc:subjects":["art/cinema"],
"dc:publisher":null,
"dc:valid":null,
"dc:format":"qwarwr",
"dc:issued":"2015-03-11T14:13:08.40Z",
"dc:modified":"2015-03-11T14:12:46.44Z",
"dc:expired":"2015-03-05T00:00:00.00Z",
"dc:coverage":"africa/Algeria",
"dc:language":"asfasf",
"dc:title":"NFile",
"dc:lastContributor":"Administrator",
"files:files":[],
"common:icon":"/icons/file.gif",
"common:icon-expanded":null,
"common:size":null,
"file:content":null,
"file:filename":null,
"relatedtext:relatedtextresources":[]},
"facets":["Downloadable","Commentable","Immutable","Versionable","Publishable","HasRelatedText"],
"changeToken":"1426083166444",
"contextParameters":{}},
{Server=[Apache-Coyote/1.1], 
X-UA-Compatible=[IE=10; IE=11], 
Content-Type=[application/json], 
Transfer-Encoding=[chunked], 
Date=[Fri, 13 Mar 2015 14:22:48 GMT]}>
	 */
	
}
