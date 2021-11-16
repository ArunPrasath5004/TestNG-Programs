package org.demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Trail {
	
	@Test(invocationCount=4,enabled=false)
	private void test1() {
		System.out.println("test 1");
	}
	@Test(priority=-1)
	private void test2() {
		System.out.println("test 2");

	}
	@Test(priority=-3)
	private void test3() {
		System.out.println("test 3");

	}
	
	

	
	
	
	
	
	
	
//	@Test(groups="smoke")
//	private void test1() {
//		System.out.println("test 1");
//		System.out.println(Thread.currentThread().getId());
//	}
//	@Test(groups= {"regression","smoke"})
//	private void test2() {
//		System.out.println("test 2");
//		System.out.println(Thread.currentThread().getId());
//
//	}
//	@Test(groups="smoke")
//	private void test3() {
//		System.out.println("test 3");
//		System.out.println(Thread.currentThread().getId());
//
//	}
//	@Test(groups="retest")
//	private void test4() {
//		System.out.println("test 4");
//		System.out.println(Thread.currentThread().getId());
//
//	}
//	@Test(groups="sanity")
//	private void test5() {
//		System.out.println("test 5");
//		System.out.println(Thread.currentThread().getId());
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Parameters({"user","pass"})
//	@Test
//	private void test(String name,String pass) {
//		
//		System.out.println(name);
//		System.out.println(pass);
//		
//	}
//	
//	@DataProvider(name="login",parallel=true)
//	private Object[][] data() {
//		
//		Object a[][]=new Object[][] {
//			{"Arun","4567"},//0
//			{"deva","76543"},//1
//			
//		};
//		return a;
//		
//	}

}
