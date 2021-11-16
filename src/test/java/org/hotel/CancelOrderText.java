package org.hotel;


import java.util.List;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CancelOrderText extends BaseClass{
	
	public CancelOrderText() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@class='select_text']")
	private List<WebElement> pageText;

	@FindBy(name="ids[]")
	private WebElement checkBox;
	
	@FindBy(name="cancelall")
	private WebElement cancelSelected;
	
	@FindBy(xpath="//input[@type='button']")
	private List<WebElement> buttonText;
	
	public List<WebElement> getPageText() {
		return pageText;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getCancelSelected() {
		return cancelSelected;
	}

	public List<WebElement> getButtonText() {
		return buttonText;
	}
	

}
