package changeSettings;
/**
 * author: rahman md foyzur [bhordupur]
 * Date  : March 2014
 * Place : Student village Turku
 **/

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;

import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;



import webdriver_automation_testing.TestSignIn;

//SKIP THE CLASS
//@Test(enabled=false)
public class ChangeSettings extends TestSignIn {


	
	//@Test(enabled=false)
	@Test(dependsOnMethods = {"testInsideGmail"},description="Go to Settings", alwaysRun=true)
	public void testGoToSettings() throws InterruptedException {
		
		try {
			
			//WAIT FOR A WHILE
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			//CLICK TO THE DROP DOWN MENU
			driver.findElement(By.xpath("//div[@class='aeH']/div/div/div[2]/div[3]/div")).click();
			// wait for 2 seconds
			Thread.sleep(2000);
			System.out.println("drop down menu opened");
			//disappearing the drop down
			driver.findElement(By.tagName("html")).click();
			System.out.println("drop down menu disappeard");
			Thread.sleep(3000L);
			//get back to the drop down menu
			driver.findElement(By.xpath("//div[@class='aeH']/div/div/div[2]/div[3]/div")).click();
			System.out.println("Open the drop down menu again");
			
			//IDENTIFY THE ELEMENT
			WebElement settings = driver.findElement(By.xpath("//*[@id=\"ms\"]/div[contains(text(),Settings)]"));
			Robot items = new Robot();
			items.delay(2000);
			int num =0;
			//GO UNTIL SETTINGS
			for(num=0;num<5;num++){
				items.keyPress(KeyEvent.VK_DOWN);
				//SEE THE VISUAL AFFECT
				Thread.sleep(1000);
			}
			items.keyRelease(KeyEvent.VK_DOWN);
			//CHECK IF DISPLAYED
			System.out.println("Settings displayed : "+ settings.isDisplayed());
			//Enter when on Settings
			items.keyPress(KeyEvent.VK_ENTER);
			items.keyRelease(KeyEvent.VK_ENTER);
			//print that you are in Settings now
			System.out.println("You r in the Settings now.!!!");
			//WAIT FOR 2 SEC
			Thread.sleep(4000);
			//GET THE REPORT
			Reporter.log("Works fine so far");
			
			} catch (Exception e) {
				
				// SEE THE ERROR MESSAGE
				System.out.println(e.getMessage());

			}
			
		
		}
	
	//@Test(enabled=false)
	@Test(dependsOnMethods ={"testGeneralSettings"},description="Drag and Drop some stars", alwaysRun=true)
	public void testDragStars(){
		try{
			
			//WAIT FOR 5 SEOCNDS
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			//CLICK ON THE ALL STARS
			WebElement allStar = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[10]/td[2]/div/table/tbody/tr/td[2]/div/span[3]"));
			new Actions(driver).moveToElement(allStar).click().perform();
			//DRAG THE ORANGE-GUILLMET TO IN USE FROM NOT IN USE
			WebElement sourceStar = driver.findElement(By.xpath("//td[@*='Ut']/div/div/span[@*='yellow-star']"));
			//"//td[@*='Ut']/div[@*='qA']"
			WebElement targetPlace = driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[10]/td[2]/div/table/tbody/tr/td[2]/div/span[3]"));
			//WAIT FOR 3 SEC
			Thread.sleep(3000);
			//MOVE THE YELLOW-STAR TO ALL STAR
			 new Actions(driver).clickAndHold(sourceStar).moveToElement(targetPlace).release(targetPlace).build().perform();
			//WAIT FOR 3 SECS
			Thread.sleep(3000);
			
			//DRAG YELLOW-BANG TO NOT IN USE FROM IN USE
			WebElement drag = driver.findElement(By.xpath("//td[@*='Ut']/div[@*='sB']/div/span[@*='orange-star']/img"));
			//PRINT CSS INFO
			System.out.println(" the height :" + drag.getCssValue("height"));
			System.out.println("the width : " +drag.getCssValue("width"));
			//ELEMENT WILL BE DROPPED ON THE BELOW ELEMENT
			WebElement drop = driver.findElement(By.xpath("//td[@*='Ut']/div[@*='qA']"));
			//new Actions(driver).clickAndHold(drag).moveByOffset(0, 18).build().perform();
			new Actions(driver).dragAndDrop(drag,drop).perform();
			System.out.println("Orange star was dropped in NOT IN USE");
			
			//WAIT FOR 2 SECONDS
			Thread.sleep(2000);
			//PRINT THE REPORT
			Reporter.log("stars were dragged");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	//@Test(enabled=false)
	@Test(dependsOnMethods ={"testGoToSettings"},description="Go to General Settings",alwaysRun=true)
	public void  testGeneralSettings(){
		
		try{
			
			Select dropDown = new Select(
					driver.findElement(By
							.xpath("/html/body/div[7]/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr/td[2]/div/select")));

			// get all the options
			Thread.sleep(5000);
			List<WebElement> allOptions = dropDown.getOptions();
			for (WebElement al : allOptions) {

				// print out the values
				System.out.println("See Gmail Display Language : \n"
						+ al.getText());
				if("Italiano".equals(al.getText())){
					break;
					}
				}
	
			//count 
			System.out.println("total language option is shown : " + allOptions.size());
			// select settings from the list
			//select UK English
			dropDown.selectByVisibleText("Deutsch");
			Thread.sleep(1000);
			dropDown.selectByIndex(8);
			if(!(driver.findElement(By.xpath("//option[@*='en']")).isSelected())){
				dropDown.selectByIndex(8);
				
			}
			if(driver.findElement(By.xpath("//option[@*='en']")).isSelected()){
				System.out.println("You have selected US ENGLISH");
			}else
				System.out.println("You have Selected UK ENGLISH");
			//CHEKC IF SIGLE VALUE WAS SELECTED OR NOT
			System.out.println(" Multiple was selected :" + dropDown.isMultiple());
			//PRINT THE MESSAGE
			System.out.println("The settings option is sucessfully selected");
			//PRINT THE REPORT
			Reporter.log("US English was selected ");
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
	
	
	//@Test(enabled=false)
	@Test(dependsOnMethods={"testDragStars"},description="Have a signature in your email")
	//let's do some styling with the text for your signature
	public void testSignature(){
		// get a signature for your email
					try {
						
						WebElement signature = driver.findElement(By.xpath("//td[@*='C6']/input[@value='1' and @name='sx_sg']"));
						//new Actions(driver).moveToElement(signature).click().perform();	
						Coordinates sCut = ((Locatable)signature).getCoordinates();
					 	sCut.inViewPort();
						signature.click();
						//WAIT FOR A SECOND
						Thread.sleep(2000);
						System.out.println("Signature button was clicked");
						
						//write your signature
						
						driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/table/tbody/tr[18]/td[2]/table[2]/tbody/tr/td[2]/span/div/table/tbody/tr/td[2]/div[2]/div/iframe")));
						WebElement insideBody = driver.findElement(By.xpath("/html/body"));
						insideBody.sendKeys("Thanks for your kind support.\nTitle :Thesis Web Driver");
						Robot selectText = new Robot();
						//PRESS THE KEY
						selectText.keyPress(KeyEvent.VK_CONTROL);
						selectText.keyPress(KeyEvent.VK_A);
						//RELEASE THE KEY NOW
						selectText.keyRelease(KeyEvent.VK_A);
						selectText.keyRelease(KeyEvent.VK_CONTROL);
						driver.switchTo().defaultContent();
						
						//OPEN THE DROPDOWN MENU
						driver.findElement(By.xpath("//td[@*='C6']/span/div/div/div/span[2]/div/div/div/div[@command='+fontName']/div/div/div[contains(text(),'Sans Serif')]")).click();
						//WAIT FOR 2 SEC
						Thread.sleep(2000);
						//CHANGE TO VERDANA FONT
						WebElement verdana = driver.findElement(By.xpath("//div[@*='verdana']/div[@*='J-N-Jz']"));
						new Actions(driver).moveToElement(verdana).click().perform();
						System.out.println("You selected => verdana {font}");
						//WAIT FOR 2 SEC
						Thread.sleep(2000);
						//CLICK ON ITALIC 
						driver.findElement(By.xpath(("//div[@*='aZ']/div/div[@command='+italic']/div/div/div"))).click();
						System.out.println("You selected ITALIC style");
						//CHANGE THE TEXT COLOR
						//TO OPEN THE COLOR MENU
						WebElement changeColor = driver.findElement(By.xpath("//td[@*='C6']/span/div/div/div/span[2]/div/div/div/div[8]"));
						changeColor.click();
						Thread.sleep(2000);
						//GET TEXT COLOR RED 
						WebElement textColor = driver.findElement(By.xpath("//td[@*='T-Kw-Jn8']/div[@*='background-color: rgb(255, 0, 0);']"));
						new Actions(driver).moveToElement(textColor).click().perform();
						Thread.sleep(2000);
						
						System.out.println("You selected red for text color");
						//DESELECT THE TEXT NOW
						driver.findElement(By.tagName("html")).click();
						//PRINT THE REPORT
						Reporter.log("Signature works so far");
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
	}
	
	
	//@Test(enabled=false)
	//click on the Save Changes Button 
	@Test(dependsOnMethods={"testSignature"},description="Save all the changes you made")
	public void testClickOntheSaveButton(){
		 try{
			 	
			 	//CHANGE THE KEYBOARD SHORTCUT ON
			 	//LOCATE THE ELEMENT
			    //WAIT FOR 5 SEOCNDS
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			 	WebElement shortCut = driver.findElement(By.xpath("//td[@*='C6']/input[@value='1' and @name='bx_hs']"));
			 	Coordinates sCut = ((Locatable)shortCut).getCoordinates();
			 	sCut.inViewPort();
			 	//CHECK IF SELECTED BEFORE
			 	if (!(shortCut.isSelected())){
			 		System.out.println("KeyBoard shortcut is off");
			 		
			 	}else{
			 		System.out.println("Already selected On [KeyBoard]");
			 		//CLICK ON IT
			 		shortCut.click();
			 	}
			 
			 	//WAIT FOR 2 SEC
			 	Thread.sleep(2000);
			 	//PRINT MESSAGE
			 	System.out.println("Keyboard shortcut is on now :)");
			 	
			 	
			 	//IDENTIFY THE ELEMENT
				WebElement saveBtn =  driver.findElement(By.xpath("//div[@* ='rU']/button[contains(text(),'Save Changes')]"));
				//GET THE COORDINATE OF THE ELEMENT
				Coordinates c = ((Locatable)saveBtn).getCoordinates();
				//SCROLL UP TO THAT ELEMENT 
				c.inViewPort();
				//GET THE INFO
				//CHECK IF THE BUTTON IS ENABLED
				System.out.println("The save button is enabled : "+saveBtn.isEnabled());
				//CHECK X AND Y COORDINATE FOR THIS BUTTON
				System.out.println("X and Y is respectively : "+ saveBtn.getLocation());
				//CHECK THE TAG NAME
				System.out.println("Get the tag name of the save changes : "+ saveBtn.getTagName());
				//GET THE BUTTON SIZE
				System.out.println("Chekc the bg color : " + saveBtn.getCssValue("background-color"));
				//GET THE TEXT
				String getText = saveBtn.getText();
				System.out.println("Text is : "+ getText);
				//VERIFY THE TEXT
				Assert.assertEquals("Save Changes",getText);
				//LET THE PAGE LOAD
				driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
				//THEN CLICK ON IT
				saveBtn.click();
				System.out.println("Changes were saved!!Execution is done.");
				Thread.sleep(5000);
				//PRINT THE REPORT
				Reporter.log("Save button saved after clicking on it");
		   }catch(Exception e){
			   //PRINT THE ERROR MESSAGE
			   System.out.println(  e.getMessage()); 
			   // System.out.println("Could not save changes");
			  Assert.fail("Could not run from ChangeSettings");
			   }
		 }
	
	
	//end of the class
}
