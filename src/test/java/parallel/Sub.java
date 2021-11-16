package parallel;

import org.testng.annotations.Test;

public class Sub {
	
	@Test
	private void test1() {
		System.out.println("test Sub 1");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	private void test2() {
		System.out.println("test Sub 2");
		System.out.println(Thread.currentThread().getId());
	}
	
	@Test
	private void test3() {
		System.out.println("test Sub 3");
		System.out.println(Thread.currentThread().getId());
	}

}
