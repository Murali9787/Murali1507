package com.stepdefinition;



import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.pages.BaseClass;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Murali
 * @Description :
 * @Date 08-07-2022
 *
 */
public class BookHotelPageStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();
	@Then("User should book a hotel by entering the credentials {string}, {string} and {string}")
	public void userShouldBookAHotelByEnteringTheCredentialsAnd(String firstName, String lastName, String billingAddress, io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> e = dataTable.asLists();
	    List<String> list1 = e.get(1);
	    pom.getBookHotelPage().bookHotel(firstName, lastName, billingAddress, list1.get(0), list1.get(1), list1.get(2), list1.get(3), list1.get(4));
	  
	}

	@Then("User should verify after book a hotel then its navigate to Book Confirmation {string}")
	public void userShouldVerifyAfterBookAHotelThenItsNavigateToBookConfirmation(String expectedConfirmationMessage) {
		WebElement bookConfirmMsg = pom.getBookConfirmationPage().getBookConfirmMsg();
		String text = bookConfirmMsg.getText();
	Assert.assertEquals("bookConfirmMsg", expectedConfirmationMessage, text);
	    
	}

	@Then("User should not any credentials in book confirmation page and click book now")
	public void userShouldNotAnyCredentialsInBookConfirmationPageAndClickBookNow() {
	    pom.getBookHotelPage().bookHotels();
	}

	@Then("user should verify an error message contains {string}, {string}, {string}, {string}, {string}, {string}, {string}")
	public void userShouldVerifyAnErrorMessageContains(String expectedFirstNameErrorMessage, String expectedLastNameErrorMessage, String expectedAddressErrorMessage, String expectedCreditCardNoErrorMessage, String expectedCreditCardtypeErrorMessage, String expectedMonthErrorMessage, String expectedCvvNoErrorMessage) {
	    WebElement firstNameErrorMsg = pom.getBookHotelPage().getFirstNameErrorMsg();
	    String text = firstNameErrorMsg.getText();
	    Assert.assertEquals("firstNameError", expectedFirstNameErrorMessage, text);
	    
	    WebElement lastNameErrorMsg = pom.getBookHotelPage().getLastNameErrorMsg();
	    String text2 = lastNameErrorMsg.getText();
	    Assert.assertEquals("lastNameError", expectedLastNameErrorMessage, text2);
		
		WebElement addressErrorMsg = pom.getBookHotelPage().getAddressErrorMsg();
		String text3 = addressErrorMsg.getText();
		Assert.assertEquals("addressError", expectedAddressErrorMessage, text3);
		
		WebElement ccErrorMsg = pom.getBookHotelPage().getCcErrorMsg();
		String text4 = ccErrorMsg.getText();
		Assert.assertEquals("ccError", expectedCreditCardNoErrorMessage, text4);
		
		WebElement ccTypeErrorMsg = pom.getBookHotelPage().getCcTypeErrorMsg();
		String text5 = ccTypeErrorMsg.getText();
		Assert.assertEquals("ccTypeError", expectedCreditCardtypeErrorMessage, text5);
		
		WebElement ccExpiryMonth = pom.getBookHotelPage().getCcExpiryMonth();
		String text6 = ccExpiryMonth.getText();
		Assert.assertEquals("ccMonthError", expectedMonthErrorMessage, text6);
		
		WebElement ccCvv = pom.getBookHotelPage().getCcCvv();
		String text7 = ccCvv.getText();
		Assert.assertEquals("ccCvvError", expectedCvvNoErrorMessage, text7);
	    
	}

}
