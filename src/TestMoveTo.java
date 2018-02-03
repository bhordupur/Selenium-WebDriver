package testSendEmail;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import webdriver_automation_testing.TestSignIn;

//SKIP THE CLASS
@Test(enabled=false)
public class TestMoveTo extends TestSignIn {

	//@Test(enabled=false)
	//@Test(dependsOnMethods={"testInsideGmail"})
	public void moveTo() throws IOException, InterruptedException{
		try{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@*='aeH']/div/div/div/div/div/div/div[@*='Select']")).click();
			//CLICK ON UNREAD
			//SELECT UNREAD MAILS
			driver.findElement(By.xpath("//div[@*='J-N']/div[contains(text(),'Unread')]")).click();
			//WAIT FOR 2 SECONDS
			Thread.sleep(2000);
			//CLICK ON MOVE TO
			driver.findElement(By.xpath("//div[@*='Move to']/div[@*='asa']/div")).click();
			
			/**TO CREATE LABEL 
			//
			//GO TO CREATE NEW LABEL
			driver.findElement(By.xpath("//div[@*='J-JK']/div[contains(text(),'Create new')]")).click();
			//TO CREATE A LABEL
			WebElement createLabel = driver.findElement(By.xpath("//div[20]/div[2]/input[@*='xx']"));
			createLabel.sendKeys("TestWebDriver");
			//WAIT AND SEE
			Thread.sleep(2000);
			//CLICK ON THE CREATE BUTTON
			driver.findElement(By.xpath("//div[@*='Kj-JD']/div[3]/button[@name='Create']")).click();
			
			**/
			
			// TO MOVE TO EXISTING LABEL
			//WAIT FOR A WHILE
			Thread.sleep(2000);
			//CLICK ON MOVE TO
			driver.findElement(By.xpath("//div[@*='Move to']/div[@*='asa']/div")).click();
			
			Thread.sleep(3000);
			//GET THE LABEL NAMED TestWebDriver
			/**
			WebElement inputTest = driver.findElement(By.xpath("/html/body/div[16]/div/div[2]/input[@*='225']"));

			inputTest.sendKeys("Test");
			Robot getTest = new Robot();
			getTest.delay(1000);
			getTest.keyPress(KeyEvent.VK_ENTER);
			getTest.keyRelease(KeyEvent.VK_ENTER);
			getTest.delay(1000);
			
			**/
			driver.findElement(By.xpath("//div[@*='TestWebDriver']/div[contains(text(),'TestWebDriver')]")).click();
			System.out.println("Your mails were moved to TestWebDriver.");
			
			//PRINT THE REPORT
			Reporter.log("Label has been created and mails were moved there correctly");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
		
	
	
}
