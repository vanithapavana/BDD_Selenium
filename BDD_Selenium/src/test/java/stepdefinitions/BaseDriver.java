package stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class BaseDriver{
	
	public WebDriver driver;
	
	public static ExtentReports report;
	public ExtentTest test;

}
