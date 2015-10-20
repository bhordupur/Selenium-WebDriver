package webdriver_automation_testing;

import google_search.GoogleSearch;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Reporter;
import org.testng.annotations.Test;



@Test(description="Login to gmail from TestSignIn class")
public class TestSignIn extends  OpenTheBrowser {
	
	
	/**
	@Test
	public void waitForAjax(int timeoutInSeconds) {
		System.out.println("Checking active ajax calls by calling jquery.active");
		try {
				if (driver instanceof JavascriptExecutor) {
		       			JavascriptExecutor jsDriver = (JavascriptExecutor)driver;

					for (int i = 0; i< timeoutInSeconds; i++) {
		       		Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
		       		// return should be a number
		       		if (numberOfAjaxConnections instanceof Long) {
		       		Long n = (Long)numberOfAjaxConnections;
		       		System.out.println("Number of active jquery ajax calls: " + n);
		       		if (n.longValue() == 0L)
		       		break;
		     	}
		     Thread.sleep(1000);
		     }
		     
		}
		     else {
		           System.out.println("Web driver: " + driver + " cannot execute javascript");
		      }
		      
		}
		          catch (InterruptedException e) {
		          System.out.println(e);
		          }
		}
	
	// for ajax calls
	 public static WebElement explicitWait(WebDriver driver,By by)  {  
    			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)  
             	.withTimeout(20, TimeUnit.SECONDS)  
             	.pollingEvery(2, TimeUnit.SECONDS)  
             	.ignoring(NoSuchElementException.class); 

     WebElement element= wait.until(new Function<WebDriver, WebElement>() {  
           public WebElement apply(WebDriver driver) {  
             return driver.findElement(By.id(":5"));  
            }  
      });  
  		return element;  
 }
	
	
	
	
	@Test(dependsOnMethods={"testBrowserTab"})
	//skip this method -> performSomeAction()
	
 
	public void performSomeAction() {
		
      //div.stui-selector-content :first-child
		FluentWait<By> fluentWait = new FluentWait<By>(By.cssSelector("a#gmail-sign-in"));
        fluentWait.pollingEvery(300, TimeUnit.MILLISECONDS);
        fluentWait.withTimeout(3000, TimeUnit.MILLISECONDS);
        fluentWait.until(new Predicate<By>() {
            public boolean apply(By by) {
                try {
                    return driver.findElement(by).isDisplayed();
                } catch (NoSuchElementException ex) {
                    return false;
                }
            }
        });
       driver.findElement(By.cssSelector("a#gmail-sign-in")).click();
		
		/**WebElement myDynamicElement = (new WebDriverWait(driver, 10))
				.until(new ExpectedCondition<WebElement>(){
				@Override
				public WebElement apply(WebDriver d) {
				    return d.findElement(By.id("gmail-sign-in"));
				}});
    
        Reporter.log("It has clicked the first element");
      }
	**/

	


	
	@Test(dependsOnMethods={"testBrowserTab"},description="Test Login method", alwaysRun=true)
	public void testLogin() throws IOException,InterruptedException{
	
		try{
			By link = By.linkText("Kirjaudu sisään");
			new WebDriverWait(driver,
					10).until(ExpectedConditions.presenceOfElementLocated(link)).click();
			Reporter.log("It has clicked the login button element");
			System.out.println("The title is from gmail : "+ driver.getTitle());
			
			//go to that tab and put
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD9));
			//Assert.assertTrue();
			Reporter.log("Now in Gmail ready for login");
			Thread.sleep(2000L);
			//lets close the second tab from the browser
			driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD2));
			Robot r = new Robot();        
	        r.keyPress(KeyEvent.VK_CONTROL);
	        r.keyPress(KeyEvent.VK_W);
	        r.keyRelease(KeyEvent.VK_CONTROL);
	        r.keyRelease(KeyEvent.VK_W);
	        System.out.println(driver.getTitle());
	        System.out.println(driver.getCurrentUrl());
	        System.out.println("Second tab was closed successfully");
	        r.delay(1000);
	        //lets close the first tab now
	        driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD1));
			Robot r1 = new Robot();        
	        r1.keyPress(KeyEvent.VK_CONTROL);
	        r1.keyPress(KeyEvent.VK_W);
	        r1.keyRelease(KeyEvent.VK_CONTROL);
	        r1.keyRelease(KeyEvent.VK_W);
	        System.out.println("First tab was closed successfully");
	        
	        //focus on the last tab now
			//wait for 5 seconds
			Thread.sleep(3000L);
			//refresh the page
			//fixed the problem
			driver.navigate().refresh(); 
			
			System.out.println(driver.getCurrentUrl());
			System.out.println(driver.getTitle());
			//write your Email
			driver.findElement(By.id("Email")).sendKeys("thesis.web.driver");
			//write your pass
			driver.findElement(By.cssSelector("input#Passwd")).sendKeys("0123-LINCOLN");
		
			//Click on the sign in button
			 driver.findElement(By.cssSelector("#signIn")).click();
			 
			//wait for gmail to be loaded 
			 driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
			 //navigate
			 driver.get("http://mail.google.com");
			 
			 //focus on this tab
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD9));
			 
			 //implicit wait to load the page
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	} catch (Exception e) {
		System.out.println(e);
		File sourceFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(
				"C:\\Users\\Public\\Pictures\\testLogin.png"));

	}

	}
	@Test(dependsOnMethods={"testLogin"},description="After logging in to gmail", alwaysRun = true)
	public void testInsideGmail() throws InterruptedException, IOException{
		
		try {
		
			//get the tab focused
			Thread.sleep(5000L);
			 driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD9));
			 
			 System.out.println("Page Title : " +driver.getTitle());
			 Reporter.log("logged in success!!!");
			 
		} catch (Exception e) {
			
			e.printStackTrace();
			File sourceFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(
					"C:\\Users\\Public\\Pictures\\testInsideGmail.png"));
		}
	}
	
}
