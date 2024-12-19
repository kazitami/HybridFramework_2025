package com.tutorialsNinja.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsNinja.Utilities.ExtentReporter;

public class MyListeners implements ITestListener{
	public ExtentReports extentReport;
	public ExtentTest extentTest;
	public WebDriver driver;
	public String testName;
	
	
	@Override
	public void onStart(ITestContext context) {
	try {
		extentReport = ExtentReporter.generateExtentReport();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

	@Override
	public void onTestStart(ITestResult result) {
		testName = result.getName();
		//System.out.println(testName + "--->Started Executing");
	    extentTest = extentReport.createTest(testName);
	    extentTest.log(Status.INFO, testName + "----> started executing");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println(testName + "--->Executed Successfully");
		extentTest.log(Status.PASS, testName + "--->Executed Successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField(driver.getCurrentUrl()).get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + testName + ".png";
		
		try {
			FileHandler.copy(source, new File(destinationFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extentTest.addScreenCaptureFromPath(destinationFile);
		extentTest.log(Status.FAIL, testName + "-----> Execution failed");
		//String testName = result.getName();
		System.out.println(testName + "failed");	
	}
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Project Execution Finished");
		extentReport.flush();
		String pathOfExtentReport = System.getProperty("user.dir")+"//test-output//ExtentReports//extentreport.html";
		File extentReport = new File(pathOfExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

