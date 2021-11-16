package org.will;

import java.io.IOException;
import java.util.Date;

import org.add.BaseClass;
import org.demo.LoginPom;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Facebook_Snaps extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	private void before() {
		System.out.println("Before time ----"+new Date());
	}
	
	@AfterMethod
	private void after(ITestResult r) throws IOException {
		System.out.println("After time ----"+new Date());
//		int status = r.getStatus();
//		String name = r.getName();
//		if (status==2) {
//			screenShot("Facebook-"+name);
//		}
		
	}
	
	@Test
	private void test1()   {
		getUrl("https://en-gb.facebook.com/");
		timeWait(5);
		LoginPom l=new LoginPom();
		
		sendValues(l.getUserName(), "Arun");
		sendValues(l.getPassword(), "456789");
		Assert.assertTrue(false);

		
	}
	@Test
	private void test2() {
		getUrl("https://en-gb.facebook.com/");
		timeWait(5);
		LoginPom l=new LoginPom();
		
		sendValues(l.getUserName(), "Subramani");
		sendValues(l.getPassword(), "@9&7438");
		
		
	}
	
	@AfterClass
	private void afterClass() {
		browserClose();
	}
	
	
	

}
