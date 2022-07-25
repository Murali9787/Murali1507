package com.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class BookConfirmationPage extends BaseClass{
	public BookConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnBook;
	
	@FindBy(id="order_no")
	private WebElement orderno;
	
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	private WebElement bookConfirmMsg;
	
	
	public WebElement getBookConfirmMsg() {
		return bookConfirmMsg;
	}

	public WebElement getOrderno() {
		return orderno;
	}

	public WebElement getBtnBook() {
		return btnBook;
	}
	
	public String bookiter() throws IOException, InterruptedException {
		Thread.sleep(5000);
		String value = getOrderno().getAttribute("value");
		click(getBtnBook());
		return value;
		
	}
}
