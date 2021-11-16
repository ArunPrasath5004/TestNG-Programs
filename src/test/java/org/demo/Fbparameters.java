package org.demo;

import java.util.Date;

import org.add.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Fbparameters extends BaseClass{
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	private void afterClass() {
		browserClose();
	}
	
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Before Method------ "+new Date());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method------- "+new Date());
	}
	
	@Test(priority=6)
	private void test1() {
		System.out.println("test 1");
	}
	
	@Test(enabled=false)
	private void test3() {
		System.out.println("test 3");
	}

	@Parameters({"username","password"})
	@Test(priority=-3)
	private void test2(@Optional("deva")String user,@Optional("456789986")String pass) {
		getUrl("https://en-gb.facebook.com/");
		
		LoginPom l=new LoginPom();
		//userName
		sendValues(l.getUserName(), user);
		
		//password
		sendValues(l.getPassword(), pass);
		
		//login 
		clickBtn(l.getLoginBtn());
		
	}

}
