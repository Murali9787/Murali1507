package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCard;

	@FindBy(id = "cc_type")
	private WebElement dDnCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement dDnMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement dDnYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCvvNumber;

	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement bookHotelMsg;
	
	@FindBy(xpath="//label[@id=\"first_name_span\"]")
	private WebElement firstNameErrorMsg;
	
	@FindBy(xpath="//label[@id=\"last_name_span\"]")
	private WebElement lastNameErrorMsg;
	
	@FindBy(xpath="//label[@id=\"address_span\"]")
	private WebElement addressErrorMsg;
	
	@FindBy(xpath="//label[@id=\"cc_num_span\"]")
	private WebElement ccErrorMsg;
	
	@FindBy(xpath="//label[@id=\"cc_type_span\"]")
	private WebElement ccTypeErrorMsg;
	
	@FindBy(xpath="//label[@id=\"cc_expiry_span\"]")
	private WebElement ccExpiryMonth;
	
	@FindBy(xpath="//label[@id=\"cc_cvv_span\"]")
	private WebElement ccCvv;

	public WebElement getFirstNameErrorMsg() {
		return firstNameErrorMsg;
	}

	public WebElement getLastNameErrorMsg() {
		return lastNameErrorMsg;
	}

	public WebElement getAddressErrorMsg() {
		return addressErrorMsg;
	}

	public WebElement getCcErrorMsg() {
		return ccErrorMsg;
	}

	public WebElement getCcTypeErrorMsg() {
		return ccTypeErrorMsg;
	}

	public WebElement getCcExpiryMonth() {
		return ccExpiryMonth;
	}

	public WebElement getCcCvv() {
		return ccCvv;
	}

	public WebElement getBookHotelMsg() {
		return bookHotelMsg;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCard() {
		return txtCreditCard;
	}

	public WebElement getdDnCardType() {
		return dDnCardType;
	}

	public WebElement getdDnMonth() {
		return dDnMonth;
	}

	public WebElement getdDnYear() {
		return dDnYear;
	}

	public WebElement getTxtCvvNumber() {
		return txtCvvNumber;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookHotel(String firstName, String lastName, String billingAddress, String creditCard, String cardType,
			String month, String year, String cVV) {
		type(getTxtFirstName(), firstName);
		type(getTxtLastName(), lastName);
		type(getTxtAddress(), billingAddress);
		type(getTxtCreditCard(), creditCard);
		selectByVisibleText(getdDnCardType(), cardType);
		selectByVisibleText(getdDnMonth(), month);
		selectByVisibleText(getdDnYear(), year);
		type(getTxtCvvNumber(), cVV);
		click(getBtnBookNow());
	}

	public void bookHotels() {
		click(getBtnBookNow());
	}

}
