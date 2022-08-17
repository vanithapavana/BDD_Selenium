package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
//	public static WebDriver driver;
	
	public BaseDriver baseDriver;
		
	public Hooks(BaseDriver picobaseDriver)
	{
		this.baseDriver=picobaseDriver;
	}
	
	@BeforeAll
	public static void createReport()
	{
		BaseDriver.report = new ExtentReports();
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//		ExtentSparkReporter spark = new ExtentSparkReporter("./target/extent_report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter("./target/extent_report_"+timeStamp+"_"+".html");
		
		BaseDriver.report.attachReporter(spark);
		
	}
	
	@AfterAll
	public static void PublishReport()
	{
		BaseDriver.report.flush();
	}
	
	
	@Before
	public void openBrowser(Scenario scenario)
	{
		String scenarioName = scenario.getName();
		
		baseDriver.test= BaseDriver.report.createTest(scenarioName);
		
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		
		baseDriver.test.info("set the path of driver executable");
		WebDriverManager.chromedriver().setup();
		
		baseDriver.test.info("Open Chrome Browser");
		baseDriver.driver=new ChromeDriver(capability);
		
		
		
	}
	
	@After
	public void closeBrowser(Scenario scenario) 
	{
		boolean failed = scenario.isFailed();
		String scenarioName = scenario.getName();

		if(failed)
		{
			TakesScreenshot t=(TakesScreenshot)baseDriver.driver;
			File srcfile = t.getScreenshotAs(OutputType.FILE);
			try 			
			{
				FileUtils.copyFile(srcfile, new File("./target/img/"+scenarioName+".png"));
			} catch (IOException e) {
				
			}
			baseDriver.test.fail(MediaEntityBuilder.createScreenCaptureFromPath("../target/img/"+scenarioName+".png").build());
		}
		
		baseDriver.test.info("Close Chrome Browser");
		baseDriver.driver.close();
	}

	
	
	/////////////// class training
	
//	//For BeforeAll and AfterAll hooks the methods should be static
//	@BeforeAll
//	public static void initReport() {
//		System.out.println("Welcome");
//	}
//	
//	@AfterAll
//	public static void publishReport() {
//		System.out.println("End");
//	}
//	@Before
//	public void beforeScenario()
//	{
//		System.out.println("------Scenario Start---------");
//	}
//	
//	@Before("@smoke")
//	public void beforeScenario1()
//	{
//		System.out.println("_________________");
//	}
//	
//	@Before(order = 2)
//	public void beforeScenario2()
//	{
//		System.out.println("--------------");
//	}
//	
//	@Before(order = 1)
//	public void beforeScenario3()
//	{
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//	}
//	@After
//	public void afterScenario()
//	{
//		System.out.println("------Scenario End---------");
//	}
//	
//	

}
