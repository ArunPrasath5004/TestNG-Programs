package parallel;

import org.testng.annotations.Test;

public class Mul {
	
	@Test
	private void test1() {
		System.out.println("test Mul 1");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test2() {
		System.out.println("test Mul 2");
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void test3() {
		System.out.println("test Mul 3");
		System.out.println(Thread.currentThread().getId());
	}

}
