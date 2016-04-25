package com.nhs.trust.service;
/**
 * @author arif.mohammed
 */
import java.io.IOException;

import com.nhs.trust.domain.Document;
import com.nhs.trust.domain.DocumentFolder;

public interface NuxeoService {
	
	public DocumentFolder findDocuments(String folderName) 
			throws IOException;
	public DocumentFolder findResources(String folderName) 
			throws IOException;
	
	public Document findResourceById(String id, boolean isResourceDocument) 
			throws IOException;
	
	public String nuxeoExternalApi(String folderName);
	
	public DocumentFolder findDocumentsBySearchText(String searchText)
			throws IOException;

}
