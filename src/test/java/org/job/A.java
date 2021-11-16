package org.job;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class A  {
	@Parameters({"username","password"})
	@Test
	private void testA1(@Optional("deva")String user,@Optional("@3123")String pass) {
		System.out.println(user);
		System.out.println(pass);
		System.out.println("test A1");
	}
	@Test(priority=-3)
	private void testA3() {
		System.out.println("test A3");
	}
	@Test
	private void testA2() {
		System.out.println("test A2");
	}
	
	
	

}
