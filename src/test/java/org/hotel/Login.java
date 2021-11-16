package org.hotel;

import org.add.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass{
	
	public Login() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(id="login")
	private WebElement loginBtn;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
