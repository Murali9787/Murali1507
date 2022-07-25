package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.pages.BaseClass;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Murali
 * @Description :
 * @Date
 *
 */
public class CommonSteps extends BaseClass{
	  public CommonSteps() {
	
			
		PageFactory.initElements(driver, this);
	}
		
	PageObjectManager pom = new PageObjectManager();

	@Then("User should verify after login page {string}")
	public void user_should_verify_after_login_page(String expectedLoginMsg) {
		Assert.assertEquals("verifyMsg", expectedLoginMsg,getAttribute(pom.getSearchHotelPage().getExpectedLoginMsg()));
	//WebElement element = pom.getSearchHotelPage().getExpectedLoginMsg();	
	//String attribute = element.getAttribute(expectedLoginMsg);
//Assert.assertEquals("verifyLoginMsg", expectedLoginMsg, attribute);
	
	}
}
