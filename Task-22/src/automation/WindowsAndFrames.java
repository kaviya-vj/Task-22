package automation;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsAndFrames {

	
	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("https://the-internet.herokuapp.com/windows");
		
		driver.manage().window().maximize();
		
		 driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		//getWindowHandle()= to store the handle of the webpage which is in focus
		 //getWindowHandles()= it stores the set for all the pages opened simutaneously
		 
		 int NumOfWindows = driver.getWindowHandles().size();
		 
		 System.out.println("Number of opened windows are:"+ NumOfWindows);
		
		 // get handles of all windows and to collect the size
		 
		String mainWindowHandle = driver.getWindowHandle();
		System.out.println(mainWindowHandle);
		

        // Get all window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        // Switch to the new window
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        // Now you are in the new window; you can interact with elements here
        String textElement = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
        System.out.println("textElement");
        
       if (textElement.equals("New Window")) {
    	   
    	 System.out.println("The text New Window is present on a page");
       }
       else{
    	   System.out.println("The text New Window is not present");
       }
        // Close the new window and switch back to the main window
        driver.close();
        driver.switchTo().window(mainWindowHandle);
        
        // Optionally, close the main browser session
        driver.quit();
    }
}