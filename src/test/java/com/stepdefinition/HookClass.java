package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.pages.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookClass extends BaseClass {

	@Before
	public void beforeScenario() throws IOException {
		System.out.println("");
		getBrowser(getPropertyFileValue("browserType"));
		loadUrl(getPropertyFileValue("url"));
		implicitly(30);
		

	}
	
	@After
	public void afterScenario(Scenario sc) {
TakesScreenshot screenshot=(TakesScreenshot)driver;
byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
sc.embed(screenshotAs, "All scenario");
close();
	}
	
	
	
	
	
}




