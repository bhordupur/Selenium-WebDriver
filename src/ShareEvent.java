
//author : bhordupur
//Date   : April 2014
//Place  : Turku


package shareAnEvent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.testng.Reporter;
import org.testng.annotations.Test;




public class ShareEvent extends browser_firefox_launch.OpenTheBrowser{
	 //@Test(enabled = false)
	@Test(dependsOnMethods={"testStartBrowser"},priority=1,successPercentage=100,description="Create an Event")
	public void testShareEvent() throws InterruptedException, AWTException{
		
		try {
			
			driver.manage().timeouts().implicitlyWait(13, TimeUnit.SECONDS);
			//driver.findElement(By.xpath("//a[@*='Share']/div[2]")).click();
			driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div[4]/div/div/div/div[2]/div[4]/div/a")).click();
			//WAIT FOR 5 SECS
			Thread.sleep(5000);
			//MOVE TO THE IFRAME
			driver.switchTo().frame(driver.findElement(By.cssSelector("div#gbsfw iframe")));
			//SEND UR TEXT
			driver.findElement(By.xpath("//div[@*='Rd']/div[2]/div[2]")).sendKeys("NS Presentaiton");
			Thread.sleep(2000);
			
			//STOP RESHARING
			driver.findElement(By.cssSelector("div.Dp div")).click();
			//WAIT FOE 2 SECS
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@*='d-A-B']/div[contains(text(),'Disable reshares')]")).click();
			Thread.sleep(2000);
			//CREATE AN EVENT
			driver.findElement(By.xpath("//div[contains(text(),'Event')]")).click();
			//WAIT FOR 5 SECS
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//CHANGE THE THEME
			//driver.findElement(By.xpath("//div[@*='MOa']/div[2]/div[@*='Gpa'][contains(text(),'Change theme')]")).click();
			//driver.switchTo().defaultContent();
			//GET INTO THE SECOND FRAME 
			//driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[17]/div/iframe")));
			//Thread.sleep(2000);
			//driver.findElement(By.xpath("//span[contains(text(),'Just kids')]")).click();
			//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			

			//GET THE SECOND THEME
			//div[@*='Ed-eb-Ic']/table/tbody/tr[1]/td/div/div/img
			//ABSOLUTE FIX THE PROBLEM
			//WebElement iTheme = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div/div[2]/div/div/div/table/tbody/tr/td/div/div/img"));
			//System.out.println("iTheme is displayed : "+ iTheme.isDisplayed());
			
			//CHECK THE THEME
			//if(!(iTheme.isSelected())){
				//iTheme.click();
				
			//}else
			//	System.out.println("Theme is selected already");
			
			//SAVE THE THEME
			//"//div[contains(text(),'Set as theme')]"
			//ABSOLUTE PATH IS SOLVING THE PROBLEM
			//WebElement saveButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div"));
			//System.out.println("Save Theme is displayed : "+ saveButton.isDisplayed());
			//System.out.println("iTheme was selected succesfully ");
			//saveButton.click();
			
			//driver.switchTo().defaultContent();

			//MOVE BACK TO THE PREVIOUS FRAME
			//driver.switchTo().frame(driver.findElement(By.cssSelector("div#gbsfw iframe")));
			//Thread.sleep(2000);
			//WRITE THE TITLE OF THE EVENT
			WebElement eventTitle = driver.findElement(By.xpath("//div[@*='yk']/div[2]/div/input[@*='Event title']"));
			eventTitle.sendKeys("Network Software");
			Thread.sleep(1000);
			//CHECK THE EVENT OPTIONS
			driver.findElement(By.xpath("//div[@*='bda']/div[2]/div[2]/div[2]")).click();
			Thread.sleep(2000);
			//SET THE  DATE
			driver.findElement(By.xpath("//div[@*='zC']/input[@*='text']")).click();
			Robot setDate = new Robot();
			setDate.delay(1000);
			setDate.keyPress(KeyEvent.VK_CONTROL);
			setDate.keyPress(KeyEvent.VK_A);
			setDate.keyRelease(KeyEvent.VK_A);
			setDate.keyRelease(KeyEvent.VK_CONTROL);
			//CLEAR THE FIELD
			setDate.keyPress(KeyEvent.VK_ENTER);
			setDate.keyRelease(KeyEvent.VK_ENTER);
			//SET THE DATE NOW
			WebElement verifyDate = driver.findElement(By.xpath("//div[@*='zC']/input[@*='text']"));
			verifyDate.sendKeys("Mon, Nov 17, 2014");
			//CLICK ON THE DATE
			verifyDate.click();
			//SEE THE CALENDAR
			Thread.sleep(2000);
			//SET THE TIME
			driver.findElement(By.xpath("//div[@*='Oma']/div")).click();
			Thread.sleep(2000);
			//END THE EVENT TIME AT 12:00 PM
			WebElement setStartTime = driver.findElement(By.xpath("//div[contains(text(),'10:00')]"));
			new Actions(driver).moveToElement(setStartTime).click().perform();
			Thread.sleep(2000);
			//SET THE END TIME
			driver.findElement(By.xpath("//span[contains(text(),'Add end time')]")).click();
			//OPEN THE DROPDOWN
			driver.findElement(By.xpath("//div[@*='yk']/div[3]/div[5]/input")).click();
			Thread.sleep(1000);
			WebElement setEndTime = driver.findElement(By.xpath("//div[contains(text(),'11:00')]"));
			new Actions(driver).moveToElement(setEndTime).click().perform();
			//WRITE THE LOCATION
			WebElement setLocation = driver.findElement(By.xpath("//div[@*='yk']/div[4]/div/input"));
			setLocation.sendKeys("ICT");
			Robot getLocation = new Robot();
			getLocation.delay(2000);
			getLocation.keyPress(KeyEvent.VK_DOWN);
			getLocation.keyRelease(KeyEvent.VK_DOWN);
			getLocation.keyPress(KeyEvent.VK_ENTER);
			getLocation.keyRelease(KeyEvent.VK_ENTER);
			getLocation.delay(1000);
			//CHECK THE LOCATION IF IT IS CORRECT
			setLocation.click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	//@Test(enabled=false)
	@Test(dependsOnMethods={"testShareEvent"},description="invite people",alwaysRun=true,priority=2)
	public void testInvitePeople() throws AWTException, InterruptedException{
		try {
			
			//INVITE PEOPLE
			WebElement invitePublic = driver.findElement(By.cssSelector("input#sbdp"));
			invitePublic.sendKeys("Pub");
			Robot getPublic = new Robot();
			getPublic.delay(1000);
			//GET PUBLIC 
			getPublic.keyPress(KeyEvent.VK_ENTER);
			getPublic.keyRelease(KeyEvent.VK_ENTER);
			//GET BHORUDPUR
			invitePublic.sendKeys("bhordupur");
			//WAIT FOR THE VALUE
			getPublic.delay(2000);
			getPublic.keyPress(KeyEvent.VK_ENTER);
			getPublic.keyRelease(KeyEvent.VK_ENTER);
			//GET PATRIC
			//invitePublic.sendKeys("patric gran");
			//WAIT FOR THE VALUE
			//getPublic.delay(2000);
			//getPublic.keyPress(KeyEvent.VK_ENTER);
			//getPublic.keyRelease(KeyEvent.VK_ENTER);
			
			//GET WHOEVER IN YOUR CIRCLE
			invitePublic.sendKeys("cir");
			//WAIT FOR THE VALUE
			getPublic.delay(2000);
			getPublic.keyPress(KeyEvent.VK_ENTER);
			getPublic.keyRelease(KeyEvent.VK_ENTER);
			
			Thread.sleep(2000);
			//CLICK INVITE
			driver.findElement(By.xpath("//td[@*='bI']/div[contains(text(),'Invite')]")).click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("Invitation is sent ");
			//PRINT THE REPORT
			Reporter.log("Invitaiton was sent successfully");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test(enabled=false)
	//@Test(dependsOnMethods={"testInsideGmail"})
	//dependsOnMethods={"testInvitePeople"},
	//@Test(dependsOnMethods={"testInvitePeople"},description="share the Event",alwaysRun=true,priority=3)
	
	public void testEventInGooglePlus(){
		
		try{
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			/**
			//div[@*=nH]/div/div[3]/div[@*='gb']/div/div/div/div/a[contains(text(),'+thesis')]")
			//"/html/body/div[7]/div[3]/div/div/div[3]/div/div/div/div/div/a"
			//html/body/div[7]/div[3]/div/div/div[3]/div/div[2]/div/div/div/a
			//("//a[contains(text(),'+thesis')]"))
			//("//*[@id='gb']/div[2]/div[1]/div[1]/div/a[contains(text(),'+thesis')]")
			
			 */
			
			driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div/div[4]/div/div/div/div/div/a[contains(text(),'+borno')]")).click();
		
			
			//PAGE TO BE LOADED
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//NOW SWITCH TO THE LAST OPENED TAB
			WebElement goToGooglePlus = driver.findElement(By.tagName("html"));
			//GET THE SECOND TAB
			goToGooglePlus.sendKeys(Keys.chord(Keys.CONTROL,Keys.NUMPAD2));
			System.out.println("See the event that is shared in Google+(PLUS)");
			
			/**
			//SCROLL DOWN THE PAGE
			JavascriptExecutor executeScript =(JavascriptExecutor)driver; //scroll down
			executeScript.executeScript("window.scrollBy(0,750)", " ");
			**/
			//CLOSE THE TAB
			Thread.sleep(5000);
			Robot googlePlusTab = new Robot(); 
			//WAIT
			googlePlusTab.delay(2000);
			googlePlusTab.keyPress(KeyEvent.VK_CONTROL);
			googlePlusTab.keyPress(KeyEvent.VK_W);
			googlePlusTab.keyRelease(KeyEvent.VK_CONTROL);
			googlePlusTab.keyRelease(KeyEvent.VK_W);
			googlePlusTab.delay(1000);
			System.out.println("The Game is over");
		}catch(Exception e){
			//GET THE ERROR
			e.printStackTrace();
		}
		
	}
	//END OF CLASS
}
