package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotel extends BaseClass{
	public SelectHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement checkbox;
	
	@FindBy(id="continue")
	private WebElement contin;

	public WebElement getCheckbox() {
		return checkbox;
	}

	public WebElement getContin() {
		return contin;
	}

}
