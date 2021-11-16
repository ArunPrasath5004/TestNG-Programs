package parallel;

import org.add.BaseClass;
import org.demo.LoginPom;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A extends BaseClass {
	
	@Parameters({"browser"})
	@BeforeClass
	private void before(String browserName) {
		
		if (browserName.equals("chrome")) {
			browserLaunch(browserName);
		}
		else if (browserName.equals("firefox")) {
			browserLaunch(browserName);
		}
		else if (browserName.equals("edge")) {
			browserLaunch(browserName);
		}
		else {
			System.out.println("Invalid browser name");
		}
		timeWait(10);
		
	}

	@Test
	private void test() {
		getUrl("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		timeWait(10);
		LoginPom l=new LoginPom();
		
		sendValues(l.getUserName(), "Arun");
		
		sendValues(l.getPassword(), "456789");
		
		clickBtn(l.getLoginBtn());
	}
	
	@AfterClass
	private void after() {
		browserClose();
	}
	
	
	
}
