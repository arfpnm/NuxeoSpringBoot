package com.nhs.trust.service;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.nhs.trust.domain.Document;
import com.nhs.trust.domain.DocumentFolder;

	public interface NuxeoVrcService {
		
	public DocumentFolder findVrcDocuments(String folderName) 
			throws IOException;
	public DocumentFolder findVrcResources(String folderName) 
			throws IOException;
	Document findResourceById(String id, boolean isResourceDocument)
			throws IOException;
	String findWebCommonAttibutesDocumentById(String id) throws IOException;
	DocumentFolder findTopLevelFoldersForVrc(String folderName)
			throws JsonParseException, JsonMappingException, IOException;
	DocumentFolder findDocumentsBySearchText(String searchText)
			throws IOException;
	DocumentFolder findRelatedPagesForSubject(String subject) throws IOException;
	DocumentFolder findAllNavVrcDocuments(String folderName)
			throws JsonParseException, JsonMappingException, IOException;

}
