package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Header {
	
	@JsonProperty("File1")
	FileContents fileContents1;
	@JsonProperty("File2")
	FileContents fileContents2;
	@JsonProperty("File3")
	FileContents fileContents3;
	@JsonProperty("File4")
	FileContents fileContents4;
	@JsonProperty("File5")
	FileContents fileContents5;
	@JsonProperty("File6")
	FileContents fileContents6;
	public FileContents getFileContents1() {
		return fileContents1;
	}
	public void setFileContents1(FileContents fileContents1) {
		this.fileContents1 = fileContents1;
	}
	public FileContents getFileContents2() {
		return fileContents2;
	}
	public void setFileContents2(FileContents fileContents2) {
		this.fileContents2 = fileContents2;
	}
	public FileContents getFileContents3() {
		return fileContents3;
	}
	public void setFileContents3(FileContents fileContents3) {
		this.fileContents3 = fileContents3;
	}
	public FileContents getFileContents4() {
		return fileContents4;
	}
	public void setFileContents4(FileContents fileContents4) {
		this.fileContents4 = fileContents4;
	}
	public FileContents getFileContents5() {
		return fileContents5;
	}
	public void setFileContents5(FileContents fileContents5) {
		this.fileContents5 = fileContents5;
	}
	public FileContents getFileContents6() {
		return fileContents6;
	}
	public void setFileContents6(FileContents fileContents6) {
		this.fileContents6 = fileContents6;
	}
	
	

}
