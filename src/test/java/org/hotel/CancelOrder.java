package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelOrder extends BaseClass {
	
	public CancelOrder() {
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="order_id_text")
	private WebElement searchBox;
	
	@FindBy(id="search_hotel_id")
	private WebElement search;

	@FindBy(id="check_all")
	private WebElement orderAllId;
	
	@FindBy(name="cancelall")
	private WebElement cancelSelected;

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getOrderAllId() {
		return orderAllId;
	}

	public WebElement getCancelSelected() {
		return cancelSelected;
	}
	
	
	
	
	
	
	
	
	
}
