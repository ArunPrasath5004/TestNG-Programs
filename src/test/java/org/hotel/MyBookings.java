package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBookings extends BaseClass {
	
	public MyBookings() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="my_itinerary")
	private WebElement myBookings;

	public WebElement getMyBookings() {
		return myBookings;
	}
	
	
	
	
	
	
	

}
