package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.BaseClass;

import cucumber.api.java.en.Then;

public class SelectHotelPageStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	@Then("User should verify after Search Hotel then its navigate to select hotel page {string}")
	public void userShouldVerifyAfterSearchHotelThenItsNavigateToSelectHotelPage(String expectedNavigateMessage) {
		WebElement selectHotelMsg = pom.getSelectHotelPage().getSelectHotelMsg();
		String text = selectHotelMsg.getText();
		boolean contains = text.contains(expectedNavigateMessage);
		Assert.assertTrue(contains);
    
	}

	@Then("User should select the hotel and click continue button")
	public void userShouldSelectTheHotelAndClickContinueButton() {
		pom.getSelectHotelPage().selectHotel();
	}

	@Then("User should verify after Select Hotel then its navigate to Book a Hotel {string}")
	public void userShouldVerifyAfterSelectHotelThenItsNavigateToBookAHotel(String expectedMessage) {
	  WebElement bookHotelMsg = pom.getBookHotelPage().getBookHotelMsg();
	  String text = bookHotelMsg.getText();
	  Assert.assertEquals("bookHotelMessage", expectedMessage, text);
	}

	@Then("User should verify an error message by without selecting the hotel and click continue an error message contains {string}")
	public void userShouldVerifyAnErrorMessageByWithoutSelectingTheHotelAndClickContinueAnErrorMessageContains(String expectedErrorMessage) {
	   pom.getSelectHotelPage().selectHotelWithoutHotel();
	}
}
