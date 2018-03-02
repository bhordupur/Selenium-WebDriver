// author : bhordupur
// Date   : March 2014
//Plae    : Turun Yliopilaskyla



package browser_firefox_launch;


import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class OpenTheBrowser {

	/**
	 * @param args
	 */
	
	 protected WebDriver driver;
	 
	// @BeforeSuite(alwaysRun=true)
	@Test
	 public void testStartBrowser() throws InterruptedException, IOException {
		 
		 try {
			 		Capabilities cap ;
			 		String browserName,browserVersion;
			
			 		// choose a firefox profile of your own
					// get the path to the custom profile
					//String path ="C://Users//bhordupur//AppData//Roaming//Mozilla//Firefox//Profiles//vqxoczvi.thesis.web.driver";
					//FirefoxProfile customProfile = new FirefoxProfile(new File(path));
					//customProfile.
			 
			 
					//INITIATE THE DRIVER INSTANCE
			 		driver = new FirefoxDriver();
					cap = ((RemoteWebDriver) driver).getCapabilities();
					
					// PRINT BROWSER NAME
					browserName = cap.getBrowserName();
					
					//PRINT VERSION
					browserVersion = cap.getVersion();
					/**
					//to test in different browser
					String p = "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe" ;
					File f = new File(p);
					FirefoxBinary getBinary = new FirefoxBinary(f);
					FirefoxProfile createProfile = new FirefoxProfile();
					FirefoxDriver driver = new FirefoxDriver(getBinary,createProfile);
					**/
					
				
					// DETECT THE RUNNING OS
					System.out.println(System.getProperty("os.name").toUpperCase()
						+ "\t ---- is running on this machine");
					
					//PRINT THE PLATFORM
					System.out.println("The system platform is : "
						+ Platform.WINDOWS);
					
					System.out.println("The browser name is :  " + browserName
						+ "   And the current verison is : " + browserVersion);
					
					//PRINT THE WINDOW SIZE
					System.out.println("Window size is by default :"+ driver.manage().window().getSize());
					
					// SET THE DIMENTION
					Dimension dimen = new Dimension(900, 700);
					driver.manage().window().setSize(dimen);
					System.out.println("Newly set window dimention is " + dimen);
					
					//WAIT FOR 3 SECONDS
					Thread.sleep(3000);
					
					//PRESS WINDOWS + ARROW LEFT
					Robot divideWindow = new Robot();
					divideWindow.keyPress(KeyEvent.VK_WINDOWS);
					divideWindow.delay(100);
					divideWindow.keyPress(KeyEvent.VK_LEFT);
					divideWindow.delay(100);
					divideWindow.keyRelease(KeyEvent.VK_LEFT);
					divideWindow.delay(100);
					divideWindow.keyRelease(KeyEvent.VK_WINDOWS);
					
					//WAIT FOR 2 SECS
					Thread.sleep(2000);
					//MAXIMISE THE BROWSER
					driver.manage().window().maximize();
					
					//PRINT THE REPORT
					Reporter.log("The browser is running");
					driver.navigate().to("http://gmail.com");
					//check on the right page
					System.out.println("The new Title is now : "+ driver.getCurrentUrl());
					//wait for gmail to be loaded 
					driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
					//write your Email
					driver.findElement(By.id("Email")).sendKeys("xxxxxx");
					//write your pass
					driver.findElement(By.cssSelector("input#Passwd")).sendKeys("xxxxxx");
				
					//Click on the sign in button
					driver.findElement(By.cssSelector("#signIn")).click();
		
			
		} catch (Exception e) {
			
			//TRACE THE ERROR
			e.printStackTrace();
			
			//TAKE AND SAVE SCREENSHOT
			File sourceFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(
					"C:\\Users\\Public\\Pictures\\testStartBrowser.png"));
			
		}
	}

	 @AfterSuite(alwaysRun=true)
		public void tearDownTheBrowser(){
		 
					//CLOSE THE DRIVER
					driver.close();
		 
		 			//QUIT THE DRIVER
		 			//driver.quit();
		}
	

}
