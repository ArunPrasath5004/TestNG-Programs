package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookConfrim extends BaseClass{
	public BookConfrim() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="order_no")
	private WebElement myBooking;
	

	public WebElement getMyBooking() {
		return myBooking;
	}


}
