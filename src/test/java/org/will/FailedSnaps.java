package org.will;

import java.io.IOException;

import org.add.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class FailedSnaps extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("---------------sucess test ---------------");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			screenShot("Facebook-"+result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("---------------Failed test-------------");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}
