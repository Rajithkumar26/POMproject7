package com.qa.UtilitiesPackage;

import java.io.IOException;
import java.util.Set;

import org.testng.IClass;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.qa.Base.ParentClass;
import com.relevantcodes.extentreports.LogStatus;

public class ExternalListeners extends ParentClass implements ISuiteListener, ITestListener{

	public ExternalListeners() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		 test =extentreport.startTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" Passed the test as the Run mode is NO");
		extentreport.endTest(test);
		extentreport.flush();
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		try {
			UtilsClass.TakeASnap();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" Failed with exception : "+result.getThrowable());
		try {
			test.log(LogStatus.FAIL, test.addScreenCapture(UtilsClass.TakeASnap()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
		extentreport.endTest(test);
		extentreport.flush();
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped the test as the Run mode is NO");

		extentreport.endTest(test);
		extentreport.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
}
