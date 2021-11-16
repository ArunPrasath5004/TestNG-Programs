package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RoomType extends BaseClass {
	public RoomType() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotels;
	
	@FindBy(id="room_type")
	private WebElement roomTypes;
	
	@FindBy(id="room_nos")
	private WebElement noOfRooms;
	
	@FindBy(id="datepick_in")
	private WebElement checkInDate;
	
	@FindBy(id="datepick_out")
	private WebElement chechOutDate;
	
	@FindBy(id="adult_room")
	private WebElement noOfAdults;
	
	@FindBy(id="child_room")
	private WebElement noOfChild;
	
	@FindBy(id="Submit")
	private WebElement submit;

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotels() {
		return hotels;
	}

	public WebElement getRoomTypes() {
		return roomTypes;
	}

	public WebElement getNoOfRooms() {
		return noOfRooms;
	}

	public WebElement getCheckInDate() {
		return checkInDate;
	}

	public WebElement getChechOutDate() {
		return chechOutDate;
	}

	public WebElement getNoOfAdults() {
		return noOfAdults;
	}

	public WebElement getNoOfChild() {
		return noOfChild;
	}

	public WebElement getSubmit() {
		return submit;
	}

	

}
