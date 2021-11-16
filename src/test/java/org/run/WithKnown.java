package org.run;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class WithKnown implements IRetryAnalyzer{
	
	int min=0,max=4;

	@Override
	public boolean retry(ITestResult result) {
		if (min<max) {
			min++;
			return true;
		}
		
		return false;
	}

}
