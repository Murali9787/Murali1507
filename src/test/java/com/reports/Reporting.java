package com.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Reporting {
	public static void generatesJVMReport(String jsonFile) {

		File file = new File("C:\\Users\\91790\\eclipse-workspace\\OMRBranchAdactinAutomation\\target");
		Configuration config = new Configuration(file, "adactin automation");
		config.addClassifications("Browser","chrome");
		config.addClassifications("version","108");
		config.addClassifications("os","win10");
		List<String>jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		ReportBuilder reportbuilder = new ReportBuilder(jsonFiles, config);
		reportbuilder.generateReports();
		}


}
