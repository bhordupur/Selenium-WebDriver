// this file must be used with shareAnEvent
//Here is it used with Chrome for log out
//I coded for both Chrome and Firefox
//I will update it soon

package logoutFromGmail;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import sharean.event.ingoogle.plus.ShareEventUsingChrome;




public class testLogoutFromGmail extends ShareEventUsingChrome   {

		@Test(enabled=false)
		//@Test(dependsOnMethods={""},description="Signed out methods")
		 public void Logout() throws IOException {
		
		        
				try{
					
				  //WAIT FOR 3 SECS
				  Thread.sleep(3000);
				  //WAIT FOR THE ELEMENT 35 SECONDS MAX
                  WebDriverWait wait = new WebDriverWait(_driver, 35);

                  WebElement elementForLogOut = wait.until(ExpectedConditions.elementToBeClickable
                		  (By.xpath("//*[@id=\"gb\"]/div[2]/div[1]/div[2]/div[5]/div[1]/a/span")));
                  elementForLogOut.click();
                  //AGAIN WAIT FOR THE ELEMENT
                  Thread.sleep(3000);
                  //CLICK TO  BE LOGGED OUT 
                  WebElement logOut =  _driver.findElement(By.xpath("//div[@*='gb_ia']/div[2]/a[contains(text(),'Sign out')]"));
                  Actions clickLogOut = new Actions(_driver);
                  clickLogOut.moveToElement(logOut).click();
                  Action perform = clickLogOut.build();
                  perform.perform();
                  
                
                  //LET THE LOCATION IF YOU  ARE SINGED OUT 
                  System.out.println("You ar successfully logged out from Gmail"+ " \n"+ elementForLogOut.getTagName());
     			  System.out.println("Test went successfully and nothing failed ->");
     			  //PRINT A MESSAGE
     			  Reporter.log("Test is done successfully.Logged Out");
                 
                 } 
		         catch(Exception e){ 
		        	 //PRINT THE ERROR MESSAGE
		        	e.printStackTrace();
		        	
                  
		 
				}
 

	}
		 
}
