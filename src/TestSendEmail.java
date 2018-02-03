package testSendEmail;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.Test;

import webdriver_automation_testing.TestSignIn;

import changeSettings.ChangeSettings;




public class TestSendEmail extends TestSignIn {
	//works fine
	//@Test(enabled = false)
	@Test(dependsOnMethods={"testInsideGmail"},description="Send An E-mail And Attach a file to it")
	public void testSendEmail() throws InterruptedException, IOException{
		
		try {
			
			
			// LET THE PAGE LOAD
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//GET THE PARENT WINDOW
			String parentWindow = driver.getWindowHandle();
			//CLICK ON THE COMPOSE BUTTON
			driver.findElement(By.xpath("//div[@*='z0']/div[contains(text(),'COMPOSE')]")).click();
			//NOW GET THE CHILD WINDOW
			for(String childWindow : driver.getWindowHandles()){
				
				//NOW SWITCH TO THE CHILD WINDOW
				driver.switchTo().window(childWindow);		
			}
			System.out.println("You have got  "+ driver.getWindowHandles().size() + " Windwos");
			//GET RID OF THIS WINDOW
			driver.findElement(By.xpath("//div[@*='aoI']/div/div[@*='Pop-in']")).click();
			//GET BACK TO THE PARENT WINDOW
			driver.switchTo().window(parentWindow);
			System.out.println("You are now in the parent Window");
			//write in to field
			driver.findElement(By.xpath("//td[@*='eV']/div/div/textarea[@name='to']")).sendKeys("thesis.web.driver@gmail.com");
			//WAIT FOR 2 SECONDS
			Thread.sleep(2000);
			//add cc also in the email
			driver.findElement(By.xpath("//div[@*='aA6']/span/span/span[contains(text(),'Cc')]")).click();
			//WAIT FOR 2 SEOCNDS TO SEE THE AFFECT
			Thread.sleep(2000);
			//write Cc add
			driver.findElement(By.xpath("//td[@*='eV']/div/div/textarea[@*='vO'][@name='cc']")).sendKeys("rupalisomoy@gmail.com");
			//subject of the email
			driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("WebDriver"); 
			//WAIT FOR 1 SEC
			Thread.sleep(2000);
			//NOW CHECK IT OUT
			driver.findElement(By.xpath("//div[starts-with(@class,'aoD')][@*='1']")).click();
	
			//GET INTO THE IFRAME
			driver.switchTo().frame(driver.findElement(By.xpath(("//td[@*='Ap']/div[2]/div/iframe"))));
			driver.findElement(By.tagName("body")).sendKeys("He" +
					"llo Sir;\nThis message is from a webdriver user.\n\t---Thanks From \nWebDriver\nCheck out this link ->");
			Thread.sleep(2000);
			//GET OUT OF THE FRAME
			driver.switchTo().defaultContent();
			//MOVE THE MOUSE TO THE ATTACH LINK
			WebElement attachFile = driver.findElement(By.xpath("//div[@*='d6']/div[@*='Attach files']/div/div/div"));
			new Actions(driver).moveToElement(attachFile).build().perform();
			System.out.println( "Icon of AttachFile is displayed : "+ attachFile.isDisplayed());
			//MOVE TO INSERT LINK
			driver.findElement(By.xpath("//div[@*='Insert link ‪(Ctrl-K)‬' and @command='+link']/div/div/div")).click();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//TEXT TO BE DISPLAYED
			driver.findElement(By.xpath("//input[@id ='linkdialog-text']")).sendKeys(" Turku UAS");
			Thread.sleep(2000);
			//WRITE THE LINK
			driver.findElement(By.cssSelector("input#linkdialog-onweb-tab-input")).sendKeys("http://www.tuas.fi/en/");
			//TEST THIS LINK
			driver.findElement(By.xpath("//div[@*='linkdialog-onweb-tab']/div[2]/div[contains(text(),'Test this link')]")).click();
			//WAIT FOR FEW SECONDS 
			Thread.sleep(2000);
			//CLOSE THE WINDWO
			Robot closeWindow = new Robot();
			closeWindow.delay(1000);
			closeWindow.keyPress(KeyEvent.VK_ALT);
			closeWindow.keyPress(KeyEvent.VK_F4);
			closeWindow.keyRelease(KeyEvent.VK_F4);
			closeWindow.keyRelease(KeyEvent.VK_ALT);
			//CLICK ON THE OK BUTTON 
			driver.findElement(By.cssSelector("div.Kj-JD-Jl button[name='ok']")).click();
			//GET THE ATTACH ICON
			driver.findElement(By.xpath("//div[@*='d6']/div[@*='Attach files']/div/div/div")).click();
			//ATTACH A FILE TO THAT EMAIL
			StringSelection attachFileToEmail = new
					StringSelection("C:\\Users\\Public\\Pictures\\moveMouseToAttachIcon.png");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attachFileToEmail, null);
					Robot fileToBeAttached = new Robot(); 
					fileToBeAttached.delay(2000);
					//fileToBeAttached.keyPress(KeyEvent.VK_ENTER);
					//fileToBeAttached.keyRelease(KeyEvent.VK_ENTER);
					fileToBeAttached.keyPress(KeyEvent.VK_CONTROL);
					fileToBeAttached.keyPress(KeyEvent.VK_V);
					fileToBeAttached.keyRelease(KeyEvent.VK_V); 
					fileToBeAttached.keyRelease(KeyEvent.VK_CONTROL);
					fileToBeAttached.delay(2000);
					fileToBeAttached.keyPress(KeyEvent.VK_ENTER);
					fileToBeAttached.keyRelease(KeyEvent.VK_ENTER); 
					//WIAT FOR 7 SEC
					fileToBeAttached.delay(7000); 
			//SEND EMAIL
			driver.findElement(By.xpath("//div[@*='Send ‪(Ctrl-Enter)‬'][contains(text(),'Send')]")).click();
			//PARENT WINDOW
			System.out.println("Bck to the parent window");
			//PRINT THE REPORT
			Reporter.log("Mail is sent succesfully!!!");
			
		
			} catch (Exception e) {
			//print the error message
			e.printStackTrace();
			File sourceFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(
					"C:\\Users\\Public\\Pictures\\testSendEmail.png"));
			System.out.println("Absolute path is :" + sourceFile.getAbsolutePath());
		}
		
		
		
	}
	
	//ATTACH A PROFILE PIXURE
	//@Test(enabled = false)
	@Test(dependsOnMethods={"testSendEmail"},description="attach a profile picture",successPercentage=100,alwaysRun=true)
	public void testAttachPicture() throws IOException, InterruptedException{
		
		//move the cursor to the element
		//WAIT FOR A WHILE
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions moveTo = new Actions(driver);
		WebElement mouseOnIcon = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div/div[2]/div[5]/div/a/span"));
		moveTo.moveToElement(mouseOnIcon).click().perform();
		Thread.sleep(2000L);
		
		//catch change profile picture
		driver.findElement(By.xpath("//div[@title='thesis driver']")).click();
		Thread.sleep(2000L);
		System.out.println("change pic was clicked successfully");
		//click on select a photo from a computer
		//get into the frame first
		driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[20]/div/iframe")));
		//click on Your photos tab
		//driver.findElement(By.xpath("//div[@id ='doclist']/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/span[3]")).click();
		//interact with the iframe elements
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[4]")).click();
		
		//ATTACH A FILE FROM YOUR LOCAL MACHINE
		
		try{
					StringSelection s = new
					StringSelection("C:\\Users\\Public\\Pictures\\testInsideGmail.png");
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
					Robot rbt = new Robot(); 
					rbt.delay(2000);
					//rbt.keyPress(KeyEvent.VK_ENTER);
					//rbt.keyRelease(KeyEvent.VK_ENTER);
					rbt.keyPress(KeyEvent.VK_CONTROL);
					rbt.keyPress(KeyEvent.VK_V);
					rbt.keyRelease(KeyEvent.VK_V); 
					rbt.keyRelease(KeyEvent.VK_CONTROL);
					rbt.delay(2000);
					rbt.keyPress(KeyEvent.VK_ENTER);
					rbt.keyRelease(KeyEvent.VK_ENTER);
					//let it load the picture 
					//wait for 7 seconds
					rbt.delay(7000); 
					
					/**
					//let's do some drag in vertically and horizontally 
					WebElement dragNdrop = driver.findElement(By.
							xpath("/html/body/div[2]/div/div[3]/div[2]/div/div[2]/div/div[9]/div/div/div[2]/div/div[2]/div/div/div/div"));
					Actions drag = new Actions(driver);
					//drag 100 px horizontally
					//drag 80 px vertically
					Thread.sleep(2000L);
					drag.dragAndDropBy(dragNdrop, 30, 15);
					**/
					
					//rotate the picture to the right
					driver.findElement(By.xpath(".//*[@id='editbar-rotate-right']/div/div[2]")).click();
					//rotate it to the left
					Thread.sleep(2000L);
					driver.findElement(By.xpath(".//*[@id ='editbar-rotate-left']/div")).click();
					
					Thread.sleep(2000);
					//add a caption 
					driver.findElement(By.xpath("//div[@*='doclist']/div/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[4]/div[contains(text(),'Add Caption')]")).click();
					//write a caption
					driver.findElement(By.xpath("/html/body/div[2]/div/div[8]/div/div/span/input")).sendKeys("DriverPhoto");
					//enter to apply
					//get the input from the keyboard 
				    Robot pressEnter = new Robot();
				    pressEnter.delay(2000);
				    pressEnter.keyPress(KeyEvent.VK_ENTER);
				    pressEnter.keyRelease(KeyEvent.VK_ENTER);
				    //PRINT THE MESSAGE
				    System.out.println("LOOK CAPTION NAME IS THERE NOW -:)-");
				    //WAIT FOR 4 SECONDS
				    Thread.sleep(4000);
					//set the profile photo
				    driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div")).click();
					System.out.println("You have a profile pix in Gmail for webdriver");
					//PRINT THE REPORT
					Reporter.log("Profile pix has been set successfully");
					//GET OUT OF IFRAME 
					driver.switchTo().defaultContent();
					//POP UP DISAPPEAR
					driver.findElement(By.tagName("html")).click();
				  } catch(Exception e){
					  	System.out.println("Failed to Attach File : "+ e);
					  	File sourceFile = ((TakesScreenshot) driver)
								.getScreenshotAs(OutputType.FILE);
					  	//PRINT THE RELATIVE PATH 
					  	System.out.println("File path is : "+ sourceFile.getCanonicalPath());
						FileUtils.copyFile(sourceFile, new File(
								"C:\\Users\\Public\\Pictures\\moveMouseToAttachIcon.png"));
				  } 
	
		}
	
		//END OF CLASS
	}
