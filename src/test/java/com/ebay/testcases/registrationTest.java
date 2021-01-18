package com.ebay.testcases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.util.TestUtility;


public class registrationTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		System.setProperty("webdriver.chrome.driver","C:/AllDrivers/LatestChrome/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData(){
		ArrayList<Object[]> testData = TestUtility.getDataFromExcel();
		return testData.iterator();
	}
	
	
	
	@Test(dataProvider="getTestData")
	public void registrationPageTest(String firstName, String lastName, String email, String password){
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		driver.findElement(By.id("lastname")).sendKeys(lastName);  // I HAVE TO PUT CLEAR HERE
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("PASSWORD")).sendKeys(password);	
	}	
	
	@AfterMethod
	public void tearDown(){
		//driver.quit();
	}
}
		