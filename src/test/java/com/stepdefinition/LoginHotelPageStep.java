package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public  class LoginHotelPageStep extends BaseClass {
	WebDriver driver;
	
	PageObjectManager pom = new PageObjectManager();
	
	
	
	@Given("User is on Adactin hotel login page")
	public void userIsOnAdactinHotelLoginPage() throws IOException {
	}

	@When("User should perform login {string}, {string}")
	public void userShouldPerformLogin(String userName, String password) throws IOException {
		pom.getLoginpage().login(userName, password);
	}

	@When("User should perform login by clicking Enter Key {string}, {string}")
	public void userShouldPerformLoginByClickingEnterKey(String userName, String password) {
		pom.getLoginpage().login(userName, password);
	}
	@Then("User should verify error message after enter the invalid credentials an error message contains {string}")
	public void userShouldVerifyErrorMessageAfterEnterTheInvalidCredentialsAnErrorMessageContains(String expectedErrorMessage) {
	    WebElement errorLogin = pom.getLoginpage().getTextErrorLogin();
	   String text = errorLogin.getText();
	   boolean contains = text.contains(expectedErrorMessage);
	   Assert.assertTrue(contains);
	    
		
	}

	

}
