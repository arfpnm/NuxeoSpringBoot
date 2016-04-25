package com.nhs.trust.controller;
/**
 * @author arif.mohammed
 */
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nhs.trust.domain.Document;
import com.nhs.trust.domain.DocumentFolder;
import com.nhs.trust.service.NuxeoService;
import com.nhs.trust.service.NuxeoVrcService;

@RestController
@ResponseBody
public class NuxeoController {

	static Logger LOGGER = LoggerFactory.getLogger(NuxeoController.class);

	@Autowired
	NuxeoService nuxeoService;

	@Autowired
	NuxeoVrcService nuxeoVrcService;

	/**
	 * @param folderName
	 * @param isChildrenRequired
	 * @param checkMetaDataForChildrenRequired
	 * @param model
	 * @return DocumentFolder
	 * @throws IOException
	 * @throws Exception
	 * Find the documents through the API call to Nuxeo
	 * isChildrenRequired and checkMetaDataForChildrenRequired will be used in future, if the folder information is required
	 */
	@RequestMapping(value= "/document-request/nhstrust/{folder}/{isChildrenRequired}/{checkMetaDataForChildrenRequired}")
	@Cacheable("documentFolder")
	public DocumentFolder findDocuments(@PathVariable("folder") String folderName, 
			@PathVariable("isChildrenRequired") String isChildrenRequired, 
			@PathVariable("checkMetaDataForChildrenRequired") String checkMetaDataForChildrenRequired, 
			ModelMap model) 
					throws  IOException, Exception{
		DocumentFolder documentFolder = folderName != null ?  nuxeoService.findDocuments(folderName) :  null;
		return documentFolder;
	}

	@RequestMapping(value= "/document-request/nhstrust/resources/{folder}")
	@Cacheable("documentFolder")
	public DocumentFolder findResources(@PathVariable("folder") String folderName, ModelMap model) 
			throws  IOException, Exception{

		DocumentFolder documentFolder = folderName != null ?  nuxeoService.findResources(folderName) :  null;
		return documentFolder;

	}

	@RequestMapping(value= "/document-request/nhstrust/{id}/{isResourceDocument}")
	@Cacheable("document")
	public Document findResourceById(@PathVariable("id") String id, boolean isResourceDocument, ModelMap model) 
			throws  IOException, Exception{
		Document document = nuxeoService.findResourceById(id, isResourceDocument);
		return document;

	}

	@RequestMapping(value= "/document-request/search/{searchText}")
	@Cacheable("documentFolder")
	public DocumentFolder findDocumentsByText(@PathVariable("searchText") String searchText, ModelMap model) 
			throws  IOException, Exception{
		DocumentFolder documentFolder = nuxeoService.findDocumentsBySearchText(searchText);
		return documentFolder;

	}


	/************************************** VRC Project APIs ***********************************************************/

	@RequestMapping(value= "/document-request/{folder}")
	public String findTopLevelFoldersForVrc(@PathVariable("folder") String folderName, ModelMap model) throws  IOException, Exception{
		DocumentFolder documentFolder = folderName != null ?  nuxeoVrcService.findTopLevelFoldersForVrc(folderName) :  null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(documentFolder);
	}
	
	//Get All the Navigation folder structure - performance hit - don't use this API method until its really required - Arif
	@RequestMapping(value= "/document-request/all-folders/{folder}")
	public String findAllForldersAndDocsForVrc(@PathVariable("folder") String folderName, ModelMap model) throws  IOException, Exception{
		DocumentFolder documentFolder = folderName != null ?  nuxeoVrcService.findAllNavVrcDocuments(folderName) :  null;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(documentFolder);
	}
	
	@RequestMapping(value= "/document-request/VRC/{folder}")
	@Cacheable("documentFolder")
	public String findVrcDocuments(@PathVariable("folder") String folderName, 
			//@PathVariable("isChildrenRequired") String isChildrenRequired, 
			//@PathVariable("checkMetaDataForChildrenRequired") String checkMetaDataForChildrenRequired, 
			ModelMap model) 
					throws  IOException, Exception{
		DocumentFolder documentFolder = folderName != null ?  nuxeoVrcService.findVrcDocuments(folderName) :  null;

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(documentFolder);
	}
	
	@RequestMapping(value= "/document-request/VRC/Recovery/{folder}")
	@Cacheable("documentFolder")
	public String findVrcUserStoriesDocuments(@PathVariable("folder") String folderName, 
			ModelMap model) 
					throws  IOException, Exception{
		folderName = "Recovery/"+folderName;
		DocumentFolder documentFolder = folderName != null ?  nuxeoVrcService.findVrcDocuments(folderName) :  null;

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		return ow.writeValueAsString(documentFolder);
	}

	@RequestMapping(value= "/document-request/vrc/resources/{folder}")
	@Cacheable("documentFolder")
	public DocumentFolder findVrcResources(@PathVariable("folder") String folderName, ModelMap model) 
			throws  IOException, Exception{

		DocumentFolder documentFolder = folderName != null ?  nuxeoVrcService.findVrcResources(folderName) :  null;
		return documentFolder;
	}

	@RequestMapping(value= "/document-request/VRC/{id}/{isResourceDocument}")
	@Cacheable("document")
	public Document findVrcDocByById(@PathVariable("id") String id, boolean isResourceDocument, ModelMap model) 
			throws  IOException, Exception{
		Document document = nuxeoVrcService.findResourceById(id, isResourceDocument);
		return document;
	}

	@RequestMapping(value= "/document-request/VRC/web-common-attributes-doc/{id}")
	public String findWebCommonAttributesDocByById(@PathVariable("id") String id, ModelMap model) 
			throws  IOException, Exception{
		return nuxeoVrcService.findWebCommonAttibutesDocumentById(id);
	}
	
	@RequestMapping(value= "/document-request/vrc/search/{searchText}")
	@Cacheable("documentFolder")
	public DocumentFolder findVrcDocumentsBySearchText(@PathVariable("searchText") String searchText, ModelMap model) 
			throws  IOException, Exception{
		DocumentFolder documentFolder = nuxeoVrcService.findDocumentsBySearchText(searchText);
		return documentFolder;

	}
	
	@RequestMapping(value= "/document-request/vrc/related-pages/{subject}")
	@Cacheable("documentFolder")
	public DocumentFolder findRelatedPagesForSubject(@PathVariable("subject") String subject) 
			throws  IOException, Exception{
		return nuxeoVrcService.findRelatedPagesForSubject(subject);
	}

}