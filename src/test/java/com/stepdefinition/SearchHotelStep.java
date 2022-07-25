package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.BaseClass;

import cucumber.api.java.en.Then;

public class SearchHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();
	@Then("User should perform Search Hotel by giving all required values {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldPerformSearchHotelByGivingAllRequiredValuesAnd(String location, String hotels, String roomType, String noOfRooms, String checkIn, String checkOut, String adultPerRoom, String childrenPerRoom) {
	    pom.getSearchHotelPage().searchHotels(location, hotels, roomType, noOfRooms, checkIn, checkOut, adultPerRoom, childrenPerRoom);
	}

	@Then("User should verify after Search Hotel it navigate to select hotel page {string}")
	public void userShouldVerifyAfterSearchHotelItNavigateToSelectHotelPage(String expectedMessage) {
			WebElement selectHotelMsg = pom.getSelectHotelPage().getSelectHotelMsg();
			String text = selectHotelMsg.getText();
			boolean contains = text.contains(expectedMessage);
			Assert.assertTrue(contains);
	    
	}

	@Then("User should perform Search Hotel by giving only mandatory values {string}, {string}, {string}, {string} and {string}")
	public void userShouldPerformSearchHotelByGivingOnlyMandatoryValuesAnd(String location, String noOfRooms, String checkIn, String checkOut, String adultroom) {
		pom.getSearchHotelPage().search_hotel(location, noOfRooms, checkIn, checkOut, adultroom);
	}

	
	@Then("User should perform Search Hotel details  {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldPerformSearchHotelDetailsAnd(String location, String hotels, String roomType, String noOfRooms, String checkIn, String checkOut, String adultPerRoom) {
	   pom.getSearchHotelPage().searchDateHotels(location, hotels, roomType, noOfRooms, checkIn, checkOut, adultPerRoom);
	}

	@Then("User should verify error message after clicking search an error message in date field it contains {string}, {string}")
	public void userShouldVerifyErrorMessageAfterClickingSearchAnErrorMessageInDateFieldItContains(String expectedCheckInErrorMessage, String expectedCheckOutErrorMessage) {
	   WebElement checkInDate = pom.getSearchHotelPage().getExpectedCheckInErrorMessage();
	   String text = checkInDate.getText();
	   Assert.assertEquals("checkinerrormsg", expectedCheckInErrorMessage, text);
	   
	   WebElement checkOutDate = pom.getSearchHotelPage().getExpectedCheckOutErrorMessage();
	   String text2 = checkOutDate.getText();
	   Assert.assertEquals("checkouterrormsg", expectedCheckOutErrorMessage, text2);
	  
	   
	}

	@Then("User should perform Search Hotel without enter any fields and verify an error message in location field it contains {string}")
	public void userShouldPerformSearchHotelWithoutEnterAnyFieldsAndVerifyAnErrorMessageInLocationFieldItContains(String expectedLocationErrorMessage) {
		pom.getSearchHotelPage().search_hotel();
	  WebElement expectedLocationErrorMessage2 = pom.getSearchHotelPage().getExpectedLocationErrorMessage();
	  String text3 = expectedLocationErrorMessage2.getText();
	  Assert.assertEquals("searchHotelErrorMessage", expectedLocationErrorMessage, text3);
	  
	}

	




}
