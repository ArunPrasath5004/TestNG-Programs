package org.job;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C {
	
	@Test(dataProvider="login")
	private void testC1(String user,String pass) {
		System.out.println(user);
		System.out.println(pass);
		System.out.println("test C1");
		System.out.println(Thread.currentThread().getId());
		
	}
	@Test
	private void testC2() {
		System.out.println("test C2");
	}
	
	@DataProvider(name="login",indices= {0,2},parallel=true)
	private Object[][] testC3() {
		Object obj[][]={
			{"Arun","45678"},//0
			{"Deva","987656"},//1
			{"Ajay","636279"}//2
		};
		return obj;

	}
	
	

}
