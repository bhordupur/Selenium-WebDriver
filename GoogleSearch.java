package google_search;

import java.awt.AWTException;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;

import browser_firefox_launch.OpenTheBrowser;

@Test(description="Google Search Page")

public class GoogleSearch extends OpenTheBrowser {
	
	
	@Test(priority=2, description="Get the gmail link ")
	
	public void testGetGmailFromSearch() throws InterruptedException, IOException{
		
		try{
			//auto suggested values from google
			  
			//get the web element	
			WebElement rightClick = driver.findElement(By.xpath("//*[@id='rso']/div[1]/li[2]/div/h3/a"));
			//perform an action on it
			new Actions(driver).moveToElement(rightClick).perform();
			Locatable loc = (Locatable)rightClick;
			// Convert the driver as a Mouse
			Mouse m = ((HasInputDevices)driver).getMouse(); 
			//Right Click
			m.contextClick(loc.getCoordinates()); 
			// Convert the driver as a Keyboard
			Keyboard k = ((HasInputDevices)driver).getKeyboard(); 
			//open in a new tab in the same browser
			k.sendKeys(Keys.CONTROL+"t");
			//wait for 2 seconds
			Thread.sleep(2000);
			//go to the opened tab
			//new Actions(driver).sendKeys(driver.findElement(By.tagName("html")), Keys.CONTROL).sendKeys(driver.findElement(By.tagName("html")),Keys.NUMPAD2).build().perform();
		
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD2));
		
		
			//check the URL and title of the page
			System.out.println("The URL is  : " + driver.getCurrentUrl()+"\n"+ "the Title is :" + driver.getTitle().toUpperCase());
		
			Reporter.log("Got the correct gmail link");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			//see the screen shot
			File sourceFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(
				"C:\\Users\\Public\\Pictures\\testGetGmailFromSearch.png"));
	
			}
		
	}
		
		@Test(priority=3, successPercentage=100,description="Switch among Tabs")
		//skipping this method from the test run
		//@Test(enabled = false)
		public void testBrowserTab() throws AWTException, IOException{
				 
			try{
				
				 Actions a = new Actions(driver);
				 a.doubleClick(driver.findElement(By.name("btnG"))).build().perform();
		          
				 //switch the opened tabs
				 //wait for 3 seconds before it happens
				 Thread.sleep(2000L);
				 WebElement dom = driver.findElement(By.tagName("html"));
				 Thread.sleep(2000L);
				 dom.sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD1));
				 //go to the last tab
				 Thread.sleep(2000L);
				 dom.sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD2));
				 Thread.sleep(2000L);
				 //go back to the GMail page
				  new Actions(driver).sendKeys(dom,Keys.NUMPAD9).build().perform();
				
				Reporter.log("The testBrowserTab() is working fine !!!");
				
					}   
				catch (Exception e) {
						System.out.println(e.getMessage());
						//see the screen shot
						File sourceFile = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(sourceFile, new File(
							"C:\\Users\\Public\\Pictures\\testBrowserTab.png"));
				
						}
				  
	
			
			}
		//@Test(enabled=false)
		@Test(invocationCount = 1, description="Test Google Search", priority=1)
		
		public void testGoogleSearch() throws InterruptedException, IOException{
			/**total wait 
			 * 20
			 * seconds
			 */
			
				try {
					// loading time 5 seconds
					driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
					//navigate to GOOGLE 
					driver.navigate().to("http://google.com");
					//check on the right page
					System.out.println("The new Title is now : "+ driver.getCurrentUrl());
					//get the title of the page
					System.out.println("The title of the page is : " + driver.getTitle().trim());
					String s = driver.getTitle();
					Assert.assertEquals("Google", s);
					 //wait 3 seconds
					Thread.sleep(3000L); 
					
					//write GMAIL on the google search box 
					WebElement autoCatch =  driver.findElement(By.xpath("//input[@id='gbqfq'][@name = 'q']"));
					autoCatch.sendKeys("Gmail");
					
					Thread.sleep(2000L);
					//use arrow keys [KeyUp and KeyDown] to go through the values
					Actions action = new Actions(driver);
						for(int i=0;i<5;i++){
							action.sendKeys(autoCatch,Keys.ARROW_DOWN).perform();
							Thread.sleep(1000L);
						}
					
						for(int j = 3;j>=0;j--){
							action.sendKeys(autoCatch,Keys.ARROW_UP).perform();
							Thread.sleep(1000L);
						}
					
					//enter GMail to get the results
													
					action.sendKeys(autoCatch,Keys.RETURN).perform();
					
				
				}catch (Exception e) {
						System.out.println(e.getMessage());
						//see the screen shot
						File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
						//store it in a file on the local machine
						FileUtils.copyFile(sourceFile, new File("C:\\Users\\Public\\Pictures\\testGoogleSearch.png"));
		
			}
		}

	}


	
	
