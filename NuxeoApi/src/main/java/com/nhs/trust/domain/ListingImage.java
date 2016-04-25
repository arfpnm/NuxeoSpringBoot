package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ListingImage {
	
		@JsonProperty("file:content")
		FileContents fileContents;

		public FileContents getFileContents() {
			return fileContents;
		}

		public void setFileContents(FileContents fileContents) {
			this.fileContents = fileContents;
		}
	
		
}
