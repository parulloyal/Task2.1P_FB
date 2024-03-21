package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {
	
	static WebDriver driver;

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) throws IOException {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver","/Users/panchamloyal/Downloads/chromedriver-mac-x64/chromedriver");  
		   
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		//sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Parul");
		
		/*
		 * Find following input fields and populate with values
		 */
		// Write code
	   WebElement lastnameelement = driver.findElement(By.id("lastname"));
	   System.out.println("Found element: " + lastnameelement);
       lastnameelement.sendKeys("Loyal");
       
       WebElement phoneelement = driver.findElement(By.id("phoneNumber"));
	   System.out.println("Found element: " + phoneelement);
       phoneelement.sendKeys("0406900002");
       
       WebElement emailElement = driver.findElement(By.id("email"));
       System.out.println("Found element: " + emailElement);
       emailElement.sendKeys("parul.loyal21@gmail.com");

       WebElement passwordElement = driver.findElement(By.id("password"));
       System.out.println("Found element: " + passwordElement);
       passwordElement.sendKeys("12345");
       
       WebElement confirmpasswordElement = driver.findElement(By.id("confirmPassword"));
       System.out.println("Found element: " + confirmpasswordElement);
       confirmpasswordElement.sendKeys("12345");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */ 
		// Write code
      
		
		/*
		 * Take screenshot using selenium API.
		 */
		// Write code
       
       
       TakesScreenshot scrShot =((TakesScreenshot)driver);
       File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
       File DestFile=new File("/Users/panchamloyal/Desktop/selenium_screenshot/officeworks_test.png");
       FileUtils.copyFile(SrcFile, DestFile);
       System.out.println("screenshot taken successfully");
		
		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.quit();	
	}
	
	public static void facebook_registration_page(String url) throws InterruptedException, IOException {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver","/Users/panchamloyal/Downloads/chromedriver-mac-x64/chromedriver"); 
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		
		
		 WebElement create_account = driver.findElement(By.xpath("//a[contains(text(), \"Create new account\")]"));
		 create_account.click();
		 
		 
		 Thread.sleep(3000);
		 
		 WebElement firstName = driver.findElement(By.name("firstname"));
	        firstName.sendKeys("Parul");
	        
	        WebElement lastName = driver.findElement(By.name("lastname"));
	        lastName.sendKeys("Loyal");

	        WebElement email = driver.findElement(By.name("reg_email__"));
	        email.sendKeys("parul.loyal21@gmail.com");
	       
	        
	       WebElement reenteremail = driver.findElement(By.name("reg_email_confirmation__"));
	       reenteremail.sendKeys("parul.loyal21@gmail.com");
	        
	        WebElement passwordInput = driver.findElement(By.name("reg_passwd__"));
	        passwordInput.sendKeys("4567");

	        WebElement birthMonth = driver.findElement(By.id("month"));
	        birthMonth.sendKeys("May"); 

	        WebElement birthDay = driver.findElement(By.id("day"));
	        birthDay.sendKeys("21"); 

	        WebElement birthYear = driver.findElement(By.id("year"));
	        birthYear.sendKeys("1996");
	        
	        WebElement gender = driver.findElement(By.xpath("//input[@value='1']")); 
	        gender.click();
	        
	        WebElement signUp = driver.findElement(By.name("websubmit"));
	        signUp.click();
	        
	        Thread.sleep(3000);
	        
	        TakesScreenshot scrShot =((TakesScreenshot)driver);
		       File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		       File DestFile=new File("/Users/panchamloyal/Desktop/selenium_screenshot/facebook_test.png");
		       FileUtils.copyFile(SrcFile, DestFile);
		       System.out.println("screenshot taken successfully");
	        
	        sleep(2);
	        // Close the browser
	        driver.quit();

	
	}
	
}
