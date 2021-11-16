package org.run;

import org.add.BaseClass;
import org.demo.LoginPom;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class Rerun extends BaseClass{
	@Test
	private void testA1() {
		System.out.println("test A1");
	}
	
	@BeforeClass
	private void before() {
		browserLaunch("chrome");
		driver.manage().window().maximize();
	}
	@Test//(retryAnalyzer=WithKnown.class)
	private void testA2() {
		getUrl("https://en-gb.facebook.com/");
		timeWait(10);
		SoftAssert a=new SoftAssert();

		String url = getUrl();
		boolean con = url.contains("face");
		a.assertTrue(con,"invalid url");
		
		LoginPom l=new LoginPom();
		//userName
		sendValues(l.getUserName(), "Arun");
		a.assertEquals(getTheAttribute(l.getUserName()),"un","invalid username");
		
		//password
		sendValues(l.getPassword(), "456789");
		
		//login 
		clickBtn(l.getLoginBtn());
		System.out.println("test A2");
		a.assertAll();
	}
	@Test
	private void testA3() {
		System.out.println("test A3");
	}
	
	@AfterClass
	private void after() {
		browserClose();
	}
	
	

}
