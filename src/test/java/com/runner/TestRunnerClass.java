package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(strict=true,plugin= {"pretty","json:target\\report.json"},dryRun=false,features= {"src\\test\\resources\\"},glue= {"com.stepdefinition"})		

/**
 * 
 * @author Murali
 * @Description:
 * @Date 08-07-2022
 *
 */
public class TestRunnerClass {
	@AfterClass
	public static void afterClass() {
	Reporting.generatesJVMReport("C:\\Users\\91790\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\report.json");
	}


}	
