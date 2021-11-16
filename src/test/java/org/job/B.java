package org.job;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class B{
	@Test
	private void testB3() {
		System.out.println("test B3");
	}
	@Parameters({"username","password"})
	@Test
	private void testB1(String user,String pass) {
		System.out.println(user);
		System.out.println(pass);
		System.out.println("test B1");
	}
	@Test
	private void testB2() {
		System.out.println("test B2");
	}
	

	
	
	

}
