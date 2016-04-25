package com.nhs.trust.service;
/**
 * @author arif.mohammed
 */
import static com.nhs.trust.utils.GeneralUtilities.buildFolderPath;
import static com.nhs.trust.utils.GeneralUtilities.folderish;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.nhs.trust.domain.Document;
import com.nhs.trust.domain.DocumentFolder;
import com.nhs.trust.utils.NuxeoObjectMapper;

@Service
public class NuxeoVrcServiceImpl implements NuxeoVrcService{

	static Logger LOGGER = LoggerFactory.getLogger(NuxeoVrcServiceImpl.class);

	@Autowired
	HttpHeaders httpHeaders;
	@Autowired
	HttpHeaders httpHeadersForResource;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private NuxeoObjectMapper mapper;
	@Value("${vrc-folder-under-section-url}")
	private String folderUnderSectionUrl;
	@Value("${vrc-main-folder-without-children-url}")
	private String justFolderUrl;
	@Value("${vrc-resource_main-folder-without-children-url}")
	private String justResourceFolderUrl;
	private String dynamicFolder;
	private String mainFolder;
	@Value("${vrc-resources_folder-under-section-url}")
	private String resourceFolderUnderSectionUrl;
	@Value("${vrc-resource-by-id-url}")
	private String resourceByIdUrl;
	@Value("${vrc-documents-for-search-text}")
	private String documentsForSearchText;
	@Value("${vrc-top-level_folders-only}")
	private String topLevelFoldersForVrc;
	@Value("${vrc-query-context}")
	private String queryContext;
	/**
	 * @param String folderName, 
	 * @param Boolean isChildrenRequired, 
	 * @param Boolean checkMetaDataForChildrenRequired
	 * @return DocumentFolder
	 * 
	 * This method returns a DocumentFolder. The REST call is made using Nuxeo API and the response json 
	 * will be converted to java object with the folder structure
	 * To retrieve the the sub folders recursively, isChildrenRequired should be true.
	 * If the checkMetaDataForChildrenRequired is true, this will override isChildrenRequired and returns the recursive 
	 * folder structure (including multilevel folder structure. 
	 * checkMetaDataForChildrenRequired will make an additional call to look at the folder level from Nuxeo. Based on the Metadata
	 * value, the checkMetaDataForChildrenRequired flag will be set.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */

	@Override
	public DocumentFolder findVrcDocuments(String folderName)
            throws JsonParseException, JsonMappingException, IOException {
        mainFolder=null;
        dynamicFolder=null;
        mainFolder=folderName;
        DocumentFolder documentFolder= buildNuxeoDocumentFolder(folderName);
        documentFolder = populateSubFolders(documentFolder, true);
        if(documentFolder != null){
            documentFolder.setFolderName(folderName);
        }
        return documentFolder;

    }
	
	@Override
	public DocumentFolder findAllNavVrcDocuments(String folderName)
            throws JsonParseException, JsonMappingException, IOException {
        mainFolder=null;
        dynamicFolder=null;
        mainFolder=folderName;
        DocumentFolder documentFolder= buildAllNavNuxeoDocumentFolder(folderName);
        documentFolder = populateAllNavSubFolders(documentFolder, true);
        if(documentFolder != null){
            documentFolder.setFolderName(folderName);
        }
        return documentFolder;

    }
	
	/**
	 * @param folderName
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * Gets the top level subfolder under vrc
	 */
	
	@Override
	public DocumentFolder findTopLevelFoldersForVrc(String folderName)
            throws JsonParseException, JsonMappingException, IOException {
        DocumentFolder documentFolder= getTopLevelFolders(folderName);
        if(documentFolder != null){
            documentFolder.setFolderName(folderName);
        }
        return documentFolder;
    }
	
	private DocumentFolder buildNuxeoDocumentFolder(String folderName) throws JsonParseException, JsonMappingException, IOException{
		DocumentFolder documentFolder=null;
		if(folderName != null && folderName.contains("|")){
			String nuxeoData = getJsonFromNuxeoApiByFolderName(justFolderUrl != null && justFolderUrl.
					equalsIgnoreCase("${main-folder-without-children-url}") ? null : justFolderUrl, folderName);
			if(nuxeoData != null){
				documentFolder=mapper.readValue(nuxeoData, DocumentFolder.class);
			}
		}else{
			String nuxeoData = getJsonFromNuxeoApiByFolderName(folderUnderSectionUrl != null && 
					folderUnderSectionUrl.equalsIgnoreCase("${folder-under-section-url}") ? null : 
						folderUnderSectionUrl, folderName);
			
			com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

			if(nuxeoData != null){
				documentFolder=mapper.readValue(nuxeoData, DocumentFolder.class);
			}
		}
		if(documentFolder != null){
			if(folderName != null && folderName.contains("/")){
				folderName= folderName.substring(folderName.lastIndexOf("/")+1,folderName.length());
			}
			documentFolder.setFolderName(folderName);
		}
		return documentFolder;
	}
	
	private DocumentFolder buildAllNavNuxeoDocumentFolder(String folderName) throws JsonParseException, JsonMappingException, IOException{
		DocumentFolder documentFolder=null;
		if(folderName != null && folderName.contains("|")){
			String nuxeoData = getJsonFromNuxeoApiByFolderName(justFolderUrl != null && justFolderUrl.
					equalsIgnoreCase("${main-folder-without-children-url}") ? null : justFolderUrl, folderName);
			if(nuxeoData != null){
				documentFolder=mapper.readValue(nuxeoData, DocumentFolder.class);
			}
		}else{
			//String nuxeoData = getJsonFromNuxeoApiByFolderName(folderUnderSectionUrl != null && 
					//folderUnderSectionUrl.equalsIgnoreCase("${folder-under-section-url}") ? null : 
						//folderUnderSectionUrl, folderName);
			//http://10.100.8.177:18080/nuxeo/api/v1/path/default-domain/sections/
			
				String nuxeoData = getJsonFromNuxeoApiByFolderName(topLevelFoldersForVrc, "VRC");
			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

			if(nuxeoData != null){
				documentFolder=mapper.readValue(nuxeoData, DocumentFolder.class);
			}
		}
		if(documentFolder != null){
			if(folderName != null && folderName.contains("/")){
				folderName= folderName.substring(folderName.lastIndexOf("/")+1,folderName.length());
			}
			documentFolder.setFolderName(folderName);
		}
		return documentFolder;
	}
	
	
	private DocumentFolder getTopLevelFolders(String folderName) throws JsonParseException, JsonMappingException, IOException{
		DocumentFolder documentFolder=null;

		ResponseEntity<String> response = restTemplate.exchange
				(MessageFormat.format(topLevelFoldersForVrc, folderName), HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);
		String nuxeoData = response.getBody();
		if(nuxeoData != null){
			documentFolder=mapper.readValue(nuxeoData, DocumentFolder.class);
		}
		if(documentFolder != null){
			documentFolder.setFolderName(folderName);
		}
		return documentFolder;
	}

	@Override
	public DocumentFolder findVrcResources(String folderName)
			throws IOException {
		DocumentFolder documentFolder = mapper.readValue(
				getJsonFromNuxeoApiByFolderNameForResources(resourceFolderUnderSectionUrl, folderName, true), 
				DocumentFolder.class
				);
		
		if(documentFolder != null){
			documentFolder.setFolderName(folderName);
		}
		return documentFolder;
	}
	
	private String getJsonFromNuxeoApiByFolderName(String urlParam, String folderName){
		if(urlParam == null || urlParam.isEmpty()){
			return null;
		}
		folderName = folderName != null && folderName.contains("|") ? folderName.replace("|", "/") : folderName;
		dynamicFolder = dynamicFolder == null ? folderName : dynamicFolder;
		String url = MessageFormat.format(urlParam, dynamicFolder);
		ResponseEntity<String> response = restTemplate.exchange
				(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);
		return response.getBody();
	}

	private String getJsonFromNuxeoApiByFolderNameForResources(String urlParam, String folderName, boolean isResourceDocument){
		if(urlParam == null || urlParam.isEmpty()) return null;
		if(folderName != null && folderName.contains("search")) return null;

		try {
			String url = MessageFormat.format(urlParam, folderName);
			HttpEntity<String> httpEntity = isResourceDocument == true ? new HttpEntity<String>(httpHeadersForResource) : new HttpEntity<String>(httpHeaders);
			ResponseEntity<String> response = restTemplate.exchange
					(url, HttpMethod.GET, httpEntity, String.class);
			return response.getBody();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private String getJsonFromNuxeoApiForWebCommonAttributes(String urlParam, String id){
		if(urlParam == null || urlParam.isEmpty()){
			return null;
		}
		String url = MessageFormat.format(urlParam, id);
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		ResponseEntity<String> response = restTemplate.exchange
				(url, HttpMethod.GET, httpEntity, String.class);
		return response.getBody();
	}

	private String getJsonFromNuxeoApiForSearchText(String urlParam, String searchText){
		if(urlParam == null || urlParam.isEmpty()){
			return null;
		}
		String url = MessageFormat.format(urlParam, searchText);
		ResponseEntity<String> response = restTemplate.exchange
				(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);
		return response.getBody();
	}

	private DocumentFolder populateSubFolders(DocumentFolder documentFolder, boolean isSubfoldersRequired) 
			throws IOException{
		List<Document> documents = documentFolder.getEntries();
		DocumentFolder subfolder = null;
		List<DocumentFolder> documentSubfolderLists = new ArrayList<DocumentFolder>();
		if(isSubfoldersRequired){
			for(Document document : documents){
				String[] facets = document.getFacets();
				if( facets != null && facets.length > 0){
					for(String facetsStr : facets){
						if(facetsStr.equalsIgnoreCase(folderish)){
							document.setFolder(true);
							dynamicFolder =  buildFolderPath(document.getPath(), mainFolder);
							subfolder = mapper.readValue(getJsonFromNuxeoApiByFolderName(folderUnderSectionUrl, document.getTitle()), DocumentFolder.class);
							if(subfolder != null){
								subfolder.setFolderName(document.getTitle()); 
								//Adding template to folder
								subfolder.setTemplate(document.getProperties() != null ? document.getProperties().getTemplate() : null);
								subfolder.setDocId(document.getUid());
								if(subfolder.getEntries() != null){
									populateSubFolders(subfolder, isSubfoldersRequired);
								}
							}
							documentSubfolderLists.add(subfolder);
						}
					}
				}
			}
			documentFolder.setSubfolder(documentSubfolderLists != null && 
					documentSubfolderLists.size() > 0 ? 
							documentSubfolderLists : null);
		}
		return documentFolder;
	}
	
	//TODO: hard coded urls - should be moved to properties file
	private DocumentFolder populateAllNavSubFolders(DocumentFolder documentFolder, boolean isSubfoldersRequired) 
			throws IOException{
		List<Document> documents = documentFolder.getEntries();
		DocumentFolder subfolder = null;
		List<DocumentFolder> documentSubfolderLists = new ArrayList<DocumentFolder>();
		if(isSubfoldersRequired){
			for(Document document : documents){
				String[] facets = document.getFacets();
				if(document.getProperties() != null && document.getProperties().isHiddenForNavigation() == false){
					if( facets != null && facets.length > 0){
						for(String facetsStr : facets){
							if(facetsStr.equalsIgnoreCase(folderish)){
								document.setFolder(true);
								dynamicFolder =  buildFolderPath(document.getPath(), mainFolder);
								subfolder = mapper.readValue(getJsonFromNuxeoApiByFolderName(topLevelFoldersForVrc, document.getTitle()), DocumentFolder.class);
								if(subfolder != null){
									subfolder.setFolderName(document.getTitle()); 
									//Adding template to folder
									subfolder.setTemplate(document.getProperties() != null ? document.getProperties().getTemplate() : null);
									subfolder.setOrder(document.getProperties() != null ? document.getProperties().getOrder() : null);
									subfolder.setDocId(document.getUid());
									if(subfolder.getEntries() != null){
										populateAllNavSubFolders(subfolder, isSubfoldersRequired);
									}
								}
								documentSubfolderLists.add(subfolder);
							}
						}
					}
				}
			}
			documentFolder.setSubfolder(documentSubfolderLists != null && 
					documentSubfolderLists.size() > 0 ? 
							documentSubfolderLists : null);
		}
		return documentFolder;
	}
	
	
    private String getJsonFromNuxeoByFolderName(String urlParam, String folderName){
        return getJsonFromNuxeoApiByFolderName(urlParam, folderName);

    }
	
	private boolean isMultilevelSubfoldersRequired(String folderName) 
			throws  IOException{
		boolean isMultiLevelSubfoldersRequired = false;
		String json = getJsonFromNuxeoApiByFolderName(justFolderUrl, folderName);
		Document document = mapper.readValue(json, Document.class);
		if(!document.getType().equalsIgnoreCase("website")){
			isMultiLevelSubfoldersRequired = document != null && document.getProperties() != null && 
					document.getProperties().getLazyloading() != null && document.getProperties().getLazyloading() == "true" ? true : false;
		}
		else{
			isMultiLevelSubfoldersRequired = true;
		}
		return isMultiLevelSubfoldersRequired;
	}
	
	
	@Override
	public Document findResourceById(String id, boolean isResourceDocument)
			throws IOException {
		resourceByIdUrl = resourceByIdUrl != null && resourceByIdUrl.equalsIgnoreCase("${resource-by-id-url}") ? null : resourceByIdUrl;
		if(resourceByIdUrl != null){
			String returnJson = getJsonFromNuxeoApiByFolderNameForResources(resourceByIdUrl, id, isResourceDocument);
			Document document = null;
			if(returnJson != null && !returnJson.isEmpty()){
				document = mapper.readValue(
					returnJson, 
					Document.class
					);
					return document;
			}
		}
		return null;
	}
	
	@Override
	public String findWebCommonAttibutesDocumentById(String id)
			throws IOException {
		try {
			if(resourceByIdUrl != null){
				return getJsonFromNuxeoApiForWebCommonAttributes(resourceByIdUrl, id); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public DocumentFolder findRelatedPagesForSubject(String subject) throws IOException{
		//String url="http://10.100.8.177:18080/nuxeo/site/api/v1/query?query=select * from Document where vrc:subjects = '"+subject+"' and ecm:path STARTSWITH '/default-domain/sections/'";
		//String url=queryContext+"select * from Document where vrc:subjects = '"+subject+"' and ecm:path STARTSWITH '/default-domain/sections/'";
		
		if(subject != null && subject.contains("'")){
			subject = subject.replace("'", "\\'");
		}
		
		StringBuilder queryBuilder = new StringBuilder(queryContext);
		queryBuilder.append("select * from Document where vrc:subjects = ");
		queryBuilder.append("'"+subject+"'");
		queryBuilder.append(" and ecm:path STARTSWITH '/default-domain/sections/' ");
		
		String url = queryBuilder.toString();
		
		//String url = MessageFormat.format(urlParam, subject);
		ResponseEntity<String> response = restTemplate.exchange
				(url, HttpMethod.GET, new HttpEntity<String>(httpHeaders), String.class);
		return new ObjectMapper().readValue(response.getBody(), DocumentFolder.class);
	}
	
	@Override
	public DocumentFolder findDocumentsBySearchText(String searchText)
			throws IOException {
		dynamicFolder=null;
		DocumentFolder documentFolder=mapper.readValue(
				getJsonFromNuxeoApiForSearchText(documentsForSearchText, searchText), 
				DocumentFolder.class);
		return documentFolder;
	}
	
}
