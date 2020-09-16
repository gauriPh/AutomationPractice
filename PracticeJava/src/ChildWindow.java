import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildWindow 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://accounts.google.com/signup");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='https://support.google.com/accounts?hl=en-GB']")).click();
		driver.findElement(By.xpath("//a[@href='https://accounts.google.com/TOS?loc=IN&hl=en-GB&privacy=true']")).click();
		Set<String>windowIDs=driver.getWindowHandles();
		Iterator<String> IDs= windowIDs.iterator();
		String parentID=IDs.next();
		String firstChildID=IDs.next();
		String secondChildID=IDs.next();
		driver.switchTo().window(firstChildID);
		System.out.println(driver.getTitle());
		driver.switchTo().window(secondChildID);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		driver.quit();
	}

}
