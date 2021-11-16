package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelBooking extends BaseClass {
	public HotelBooking() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="first_name")
	private WebElement firstName;
	
	@FindBy(id="last_name")
	private WebElement lastName;
	
	@FindBy(id="address")
	private WebElement address;
	
	@FindBy(id="cc_num")
	private WebElement creditCard;
	
	@FindBy(id="cc_type")
	private WebElement cardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement expiryMonth;
	
	@FindBy(id="cc_exp_year")
	private WebElement expiryyear;
	
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	
	@FindBy(id="book_now")
	private WebElement bookNow;

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCreditCard() {
		return creditCard;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getExpiryMonth() {
		return expiryMonth;
	}

	public WebElement getExpiryyear() {
		return expiryyear;
	}

	public WebElement getCvv() {
		return cvv;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

}
