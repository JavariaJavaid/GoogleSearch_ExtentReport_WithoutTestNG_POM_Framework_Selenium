package Test;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.GoogleSearch_Page;
public class Simple_ExtentReport_Script
{
	
	private static WebDriver driver =null;
	
	
	
	public static void main(String args[])
	{
		ExtentHtmlReporter ExtentHtmlRep = new ExtentHtmlReporter("Extent.html");
		ExtentReports ExtentRep = new ExtentReports();
		ExtentRep.attachReporter(ExtentHtmlRep);
		
		ExtentTest  test = ExtentRep.createTest("Google search test 1","this is the test validate google search");
		
		System.setProperty("webdriver.chrome.driver","D:\\PSEB\\SETUP\\chromedriver 104\\chromedriver.exe");
		test.log(Status.INFO, "Starting TestCase");
		
		String BaseURL="https://www.google.com";
		driver.get(BaseURL);
		test.pass("Navigate to google Page");
		GoogleSearch_Page GoogleSearchObj = new GoogleSearch_Page(driver);
		GoogleSearchObj.Search_field("Selenium Automation");
		test.pass("Entered text in search field");
		
		GoogleSearchObj.Search_button();
		test.pass("Pressed Keyboard entered");
		
		driver.close();
		test.pass("Close the browser");
	
	}
	
//	public static void CloseDriver()
//	{
//		driver.close();
//	}
	}