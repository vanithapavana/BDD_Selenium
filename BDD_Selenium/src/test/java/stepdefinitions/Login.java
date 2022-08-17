package stepdefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ETTPage;
import pages.LoginPage;


public class Login{
	
	public BaseDriver baseDriver;
	
	public LoginPage loginPage;
	public ETTPage ettPage;
	public ExtentTest test;
	
	public Login(BaseDriver picobaseDriver)
	{
		this.baseDriver=picobaseDriver;		
		loginPage=new LoginPage(baseDriver.driver);
		ettPage=new ETTPage(baseDriver.driver);
		test = baseDriver.test;
	}
	

	@Given("I nvaigate to login page")
	public void iNvaigateToLoginPage() {
		
//		Hooks.driver.get("https://demo.actitime.com/login.do");
//		baseDriver.test.info("Launching the url");
		test.info("Launching the url");
		baseDriver.driver.get("https://demo.actitime.com/login.do");
	    
	}
	@When("I enter {string} as username")
	public void iEnterAsUsername(String un) {
//		Hooks.driver.findElement(By.id("username")).sendKeys("admin");
//		baseDriver.driver.findElement(By.id("username")).sendKeys("admin");
		test.info("Enter the username: "+un);
		loginPage.setUserName(un);
	}
	@When("I enter {string} as password")
	public void iEnterAsPassword(String pw) {
//	   Hooks.driver.findElement(By.name("pwd")).sendKeys("manager");
//		baseDriver.driver.findElement(By.name("pwd")).sendKeys("manager");
		test.info("Enter the username: "+pw);
		loginPage.setPassword(pw);
	}
	@When("I click on login button")
	public void iClickOnLoginButton() {
//		Hooks.driver.findElement(By.xpath("//div[.='Login ']")).click();
//		baseDriver.driver.findElement(By.xpath("//div[.='Login ']")).click();
		test.info("Click on Login Button");
		loginPage.clickLoginButton();
	   
	}
	@Then("I should see home page")
	public void iShouldSeeHomePage() {
//		WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
//		WebDriverWait wait=new WebDriverWait(baseDriver.driver, Duration.ofSeconds(10));
//		try
//		{
//			wait.until(ExpectedConditions.titleContains("Enter"));
//			System.out.println("Home Page is displayed");
//			
//		}
//		catch (Exception e)
//		{
//			System.out.println("Home Page is Not displayed");
//		}
		boolean result = ettPage.verifyHomepageIsDisplayed("Enter");
		if(result) {
			test.pass("Home Page is displayed");
		}
		
		else {
			test.fail("Home Page is not displayed");
			
		}
		assert result;
	   
	}
	


	
//	@When("We enter below mentioned credentials")
//	public void weEnterBelowMentionedCredentials(DataTable dataTable) {
//		List<Map<String, String>> data = dataTable.asMaps();
//		System.out.println("-------------------------");
//		for(Map<String, String> row:data)
//		{
//			Set<String> allkeys = row.keySet();
//			for(String key:allkeys)
//			{
//				String v=row.get(key);
//				System.out.print(v+" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("-------------------------");
//		   
//	}
	
//	@When("We enter below mentioned credentials")
//	public void weEnterBelowMentionedCredentials(DataTable dataTable) {
//		List<Map<String, String>> data = dataTable.asMaps();
//		System.out.println("-------------------------");
//		for(Map<String, String> row:data)
//		{
//			String un=row.get("username");
//			System.out.print("Username "+un+" ");
//			
//			String pw=row.get("password");
//			System.out.println("Password "+pw);
//		}
//		
//		System.out.println("-------------------------");
//		   
//	}
	
//	@When("We enter below mentioned credentials")
//	public void weEnterBelowMentionedCredentials(DataTable dataTable) {
//		List<List<String>> data = dataTable.asLists();
//		System.out.println("-------------------------");
//		int rc=data.size();
//		for(int i=1;i<rc;i++)
//		{
//			int cc = data.get(i).size();
//			
//			for(int j=0;j<cc;j++)
//			{
//				String v=data.get(i).get(j);
//				System.out.println(v+" ");
//			}
//			System.out.println( );
//		}
//		
//		System.out.println("-------------------------");
//		   
//	}
	
//	@When("We enter below mentioned credentials")
//	public void weEnterBelowMentionedCredentials(DataTable dataTable) {
//		List<List<String>> data = dataTable.asLists();
//		System.out.println("-------------------------");
//		for(List<String> row:data)
//		{
//			for(String cell:row)
//			{
//				System.out.println(cell+" ");
//			}
//			System.out.println();
//		}
//		
//		System.out.println("-------------------------");
//		
//		
//	   
//	}

	
//	@When("We enter below mentioned credentials")
//	public void weEnterBelowMentionedCredentials(DataTable dataTable) {
//		List<List<String>> data = dataTable.asLists();
//		System.out.println("-------------------------");
//		
//		for(int i=1;i<=2;i++) {
//			String un=data.get(i).get(0); //data is reading from datatable present in login8 feature file
//			System.out.println("Username is :"+un);
//			
//			String pw=data.get(i).get(1);
//			System.out.println("Password is :"+pw);
//			
//		}
//		System.out.println("-------------------------");
//		
//		
//	   
//	}

//	
//	@When("We enter valid username {} and password {}")   //{}-->it represents anything
//	public void weEnterValidAdminAndManager(String un, String pw) {
//		System.out.println("Enter username: "+un);
//		System.out.println("Enter Password: "+pw);
//	    
//	}
//
//	
//	@Given("path of driver exe is set")
//	public void pathOfDriverExeIsSet() {
//		System.out.println("path of driver exe is set");
//	}
//	@When("open the browser")
//	public void openTheBrowser() {
//		System.out.println("open the browser");
//	}
//	@Then("Browser is displayed")
//	public void browserIsDisplayed() {
//		System.out.println("Browser is displayed");
//	}
//
//
//	@Given("Login Page is Displayed")
//	public void login_page_is_displayed() {
//		System.out.println("Login Page is displayed");
//
//	}
//	@When("We enter valid username and password")
//	public void we_enter_valid_username_and_password() {
//		System.out.println("We enter valid username and password");
//
//	}
//	@When("We click on Login button")
//	public void we_click_on_login_button() {
//		System.out.println("We click on Login button");
//
//	}
//	@Then("Home Page should be displayed")
//	public void home_page_should_be_displayed() {
//		System.out.println("Home Page should be displayed");
//		//		Assert.assertEquals("abcd", "xyz");
//
//	}
//
//	@When("We enter invalid username and password")
//	public void weEnterInvalidUsernameAndPassword() {
//		System.out.println("We enter invalid username and password");
//	}
//
//	@Then("Err message is displayed")
//	public void errMessageIsDisplayed() {
//		System.out.println("Err message is displayed");
//	}


	
}
