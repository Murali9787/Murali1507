package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Then;

/**
 * 
 * @author Gokul
 * @Description :
 * @Date 08-07-2022
 *
 */
public class CancelBookingpageStep {
	PageObjectManager pom = new PageObjectManager();
	@Then("User should cancel the order Id")
	public void userShouldCancelTheOrderId() throws IOException, InterruptedException {
		String bookiter = pom.getBookConfirmationPage().bookiter();
	    pom.getCancelBookingPage().cancelBooking(bookiter);
	    
	}

	@Then("User should delete the existing order Id {string}")
	public void userShouldDeleteTheExistingOrderId(String orderId) throws InterruptedException {
	   pom.getCancelBookingPage().cancelBooking(orderId);
	}

	@Then("User should verify the cancelled message {string}")
	public void userShouldVerifyTheCancelledMessage(String expectedOrderNocancelMessage) {
	   WebElement cancelOrderId = pom.getCancelBookingPage().getDeleteMessage();
	   String text = cancelOrderId.getText();
	   Assert.assertEquals("cancelOrder", expectedOrderNocancelMessage, text);
	}
}
