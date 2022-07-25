package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelBookingPage extends BaseClass {
	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="search_result_error")
	private WebElement deleteMessage;
	
	
	public WebElement getDeleteMessage() {
		return deleteMessage;
	}

	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement bookiternity;
	
	public WebElement getBookiternity() {
		return bookiternity;
	}
	@FindBy(id="order_id_text")
	private WebElement txtBox;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement btnCancel;
	
	@FindBy(name="cancelall")
	private WebElement btncancelSelected;

	public WebElement getTxtBox() {
		return txtBox;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getBtnCancel() {
		return btnCancel;
	}
	
	
	public WebElement getBtncancelSelected() {
		return btncancelSelected;
	}

	
	public void cancelBooking(String bookId) throws InterruptedException {
		Thread.sleep(5000);
		click(getBookiternity());
		type(getTxtBox(), bookId);
		click(getBtnGo());
		click(getBtnCancel());
		alertAccept();
	}
	
}

	
