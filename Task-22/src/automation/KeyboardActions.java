package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class KeyboardActions {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();

		// Switch to the top frame
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));

		// Check if the top frame contains three frames
		List<WebElement> frames = driver.findElements(By.cssSelector("frame"));
		if (frames.size() == 3) {
			System.out.println("The top frame has three frames");
		} else {
			System.out.println("The top frame does not contain three frames");
		}

		// Switch to the left frame using CSS selector and check text
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));
		String textLeft = driver.findElement(By.cssSelector("body")).getText();
		System.out.println("Text in left frame: " + textLeft);
		if (textLeft.contains("LEFT")) {
			System.out.println("Verified: The left frame contains the text 'LEFT'");
		} else {
			System.out.println("Verification Failed: The left frame does not contain the text 'LEFT'");
		}

		// Switch back to the top frame and then to the middle frame
		driver.switchTo().parentFrame(); // Go back to frame-top
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		String textMiddle = driver.findElement(By.cssSelector("div")).getText(); // Text is inside a <div>
		System.out.println("Text in middle frame: " + textMiddle);
		if (textMiddle.contains("MIDDLE")) {
			System.out.println("Verified: The middle frame contains the text 'MIDDLE'");
		} else {
			System.out.println("Verification Failed: The middle frame does not contain the text 'MIDDLE'");
		}

		// Switch back to the top frame and then to the right frame
		driver.switchTo().parentFrame(); // Go back to frame-top
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-right']")));
		String textRight = driver.findElement(By.cssSelector("body")).getText();
		System.out.println("Text in right frame: " + textRight);
		if (textRight.contains("RIGHT")) {
			System.out.println("Verified: The right frame contains the text 'RIGHT'");
		} else {
			System.out.println("Verification Failed: The right frame does not contain the text 'RIGHT'");
		}

		// Switch back to the main content and then to the bottom frame
		driver.switchTo().defaultContent(); // Go back to main page content
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));

		String bottomText = driver.findElement(By.cssSelector("body")).getText(); // Corrected to use body for text
		System.out.println("Text in bottom frame: " + bottomText);

		if (bottomText.contains("BOTTOM")) {
			System.out.println("Verified: The bottom frame contains the text 'BOTTOM'");
		} else {
			System.out.println("Verification Failed: The bottom frame does not contain the text 'BOTTOM'");
		}
		
		// Close the driver
		driver.quit();
	}
}
