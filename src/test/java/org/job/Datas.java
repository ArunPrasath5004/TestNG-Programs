package org.job;

import org.testng.annotations.DataProvider;

public class Datas {
	
	@DataProvider(name="login")
	private Object[][] login() {
		Object [][]log=new Object[][] {
			{"ArunPrasath5005","Adactin@123"}
		};
		return log;
	}
	
	@DataProvider(name="Date")
	private Object[][] date() {
		Object dt[][]=new Object[][] {
			{"04/10/2021","05/10/2021"}
	
		};
		return dt;
	}
	
	@DataProvider(name="Bio")
	private Object[][] personal() {
		Object per[][]=new Object[][] {
			{"Arun","Prasath","Boston,New York","4001 5900 0000 0001","737"}
		};
		return per;
	}
	
	
	
	
	

}
