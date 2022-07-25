package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotel;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNo;

	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;

	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;

	@FindBy(id = "adult_room")
	private WebElement dDnAdultPerRoom;

	@FindBy(id = "child_room")
	private WebElement dDnChildrenPerRoom;

	@FindBy(id = "Submit")
	private WebElement btnSearch;
	
	@FindBy(id="username_show")
	private WebElement expectedLoginMsg;
	
	@FindBy(id="location_span")
	private WebElement expectedLocationErrorMessage;
	
	@FindBy(id="checkin_span")
	private WebElement expectedCheckInErrorMessage;
	
	@FindBy(id="checkout_span")
	private WebElement expectedCheckOutErrorMessage;
	
		
	
	public WebElement getExpectedCheckInErrorMessage() {
		return expectedCheckInErrorMessage;
	}

	public WebElement getExpectedCheckOutErrorMessage() {
		return expectedCheckOutErrorMessage;
	}

	public WebElement getExpectedLocationErrorMessage() {
		return expectedLocationErrorMessage;
	}

	public WebElement getExpectedLoginMsg() {
		return expectedLoginMsg;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotel() {
		return dDnHotel;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultPerRoom() {
		return dDnAdultPerRoom;
	}

	public WebElement getdDnChildrenPerRoom() {
		return dDnChildrenPerRoom;
	}

	public WebElement getBtnSearch() {
		return btnSearch;
	}

	
	public void searchHotels(String location, String hotels, String roomType, String noOfRooms, String checkIn,
			String checkOut, String adultPerRoom, String childrenPerRoom) {
		selectByValue(getdDnLocation(), location);
		selectByValue(getdDnHotel(), hotels);
		selectByValue(getdDnRoomType(), roomType);
		selectByVisibleText(getdDnRoomNo(), noOfRooms);
		type(getTxtCheckInDate(), checkIn);
		type(getTxtCheckOutDate(), checkOut);
		selectByVisibleText(getdDnAdultPerRoom(), adultPerRoom);
		selectByVisibleText(getdDnChildrenPerRoom(), childrenPerRoom);
		click(getBtnSearch());
	}

	public void search_hotel(String location, String noOfRooms, String checkIn, String checkOut, String adultPerRoom) {
		selectByValue(getdDnLocation(), location);
		selectByVisibleText(getdDnRoomNo(), noOfRooms);
		type(getTxtCheckInDate(), checkIn);
		type(getTxtCheckOutDate(), checkOut);
		selectByVisibleText(getdDnAdultPerRoom(), adultPerRoom);
		click(getBtnSearch());
	}
	public void searchDateHotels(String location, String hotels, String roomType, String noOfRooms, String checkIn,
			String checkOut, String adultPerRoom) {
		selectByValue(getdDnLocation(), location);
		selectByValue(getdDnHotel(), hotels);
		selectByValue(getdDnRoomType(), roomType);
		selectByVisibleText(getdDnRoomNo(), noOfRooms);
		clear(getTxtCheckInDate());
		type(getTxtCheckInDate(), checkIn);
		clear(getTxtCheckOutDate());
		type(getTxtCheckOutDate(), checkOut);
		selectByVisibleText(getdDnAdultPerRoom(), adultPerRoom);
		click(getBtnSearch());
	}
	

	public void search_hotel() {
		click(getBtnSearch());
	}

}
