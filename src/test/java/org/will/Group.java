package org.will;

import org.testng.annotations.Test;

public class Group {
	
	@Test(groups= {"smoke","regression"})
	private void test1() {
		System.out.println("test 1");
	}
	@Test(groups= {"sanity","retest"})
	private void test2() {
		System.out.println("test 2");
	}
	@Test(groups="regression")
	private void test3() {
		System.out.println("test 3");
	}
	@Test(groups="smoke")
	private void test4() {
		System.out.println("test 4");
	}
	@Test(groups= "sanity")
	private void test5() {
		System.out.println("test 5");
	}
	@Test(groups="retest")
	private void test6() {
		System.out.println("test 6");
	}
	@Test(groups="smoke")
	private void test7() {
		System.out.println("test 7");
	}
	
	
	

}
