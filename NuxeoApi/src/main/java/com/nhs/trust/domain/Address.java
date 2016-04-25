package com.nhs.trust.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 * @author arif.mohammed
 *
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Address {
	
	String addressline1;
	String addressline2;
	String county;
	String postcode;
	String city;
	String coordinates;
	
	public String getAddressline1() {
		return addressline1;
	}
	public void setAddressline1(String addressline1) {
		this.addressline1 = addressline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public String toString() {
		return "Address [addressline1=" + addressline1 + ", addressline2="
				+ addressline2 + ", county=" + county + ", postcode="
				+ postcode + ", city=" + city + "]";
	}
	

}
