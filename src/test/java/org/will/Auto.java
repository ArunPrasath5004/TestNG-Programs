package org.will;

import org.add.BaseClass;
import org.demo.LoginPom;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Auto extends BaseClass {
	
	@BeforeClass
	private void beforeClass() {
		browserLaunch("chrome");
		driver.manage().window().maximize();
		timeWait(10);
	}
	
	@Test(dataProvider="datas",dataProviderClass=DataDriven_Provider.class) 
	private void test(String user,String pass) {
		
		getUrl("https://en-gb.facebook.com/");
		
		LoginPom l=new LoginPom();
		
		sendValues(l.getUserName(), user);
		
		sendValues(l.getPassword(), pass);
		
		clickBtn(l.getLoginBtn());
		driver.navigate().refresh();
		timeWait(5);
		
	}
	
	

}
