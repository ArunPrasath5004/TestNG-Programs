package org.demo;


import org.add.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Sample extends BaseClass{
	
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
		System.out.println("Before Method ");
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println("After Method ");
	}
	
	@Test(priority=6)
	private void test1() {
		System.out.println("test 1");
	}
	
	@Test(enabled=false)
	private void test3() {
		System.out.println("test 3");
	}
	
	@Test(priority=-3)
	private void test2() {
		getUrl("https://en-gb.facebook.com/");
		String url = getUrl();
		boolean contains = url.contains("facebook");
		
		//Soft Assert
		SoftAssert as=new SoftAssert();
		as.assertTrue(contains,"Verify Url"); //(boolean,string)
		timeWait(5);
		
		LoginPom l=new LoginPom();
		//userName
		sendValues(l.getUserName(), "Arun");
		as.assertEquals(getTheAttribute(l.getUserName()), "deva","verify UserName");//(Actual,expected,string)
		
		//password
		sendValues(l.getPassword(), "456789");
		as.assertEquals(getTheAttribute(l.getPassword()),"456789","verify password");
		
		//login URL
		clickBtn(l.getLoginBtn());
		timeWait(5);
		String AfertUrl = getUrl();
		boolean contains4 = AfertUrl.contains("privacy_mutation");
		as.assertTrue(contains4,"verify After Login URL");
		
		as.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
