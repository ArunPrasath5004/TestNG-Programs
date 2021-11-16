package parallel;

import org.testng.annotations.Test;

public class Add {
	
	@Test
	private void test1() {
		System.out.println("test Add 1");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test2() {
		System.out.println("test Add 2");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test3() {
		System.out.println("test Add 3");
		System.out.println(Thread.currentThread().getId());
	}
	
	

}
