package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "radiobutton_0")
	private WebElement radioButton;

	@FindBy(id = "continue")
	private WebElement btnContinue;
	@FindBy(xpath="//td[text()='Select Hotel ']")
	private WebElement SelectHotelMsg;

	public WebElement getSelectHotelMsg() {
		return SelectHotelMsg;
	}


	public WebElement getRadioButton() {
		return radioButton;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	// Scenario Outline: Verifying Adactin hotel to Select Hotel
	public void selectHotel() {
		click(getRadioButton());
		click(getBtnContinue());
	}

	// Scenario Outline: Verifying Adactin hotel to Select Hotel Without select any credentials
	public void selectHotelWithoutHotel() {
		click(getBtnContinue());
	}
}
