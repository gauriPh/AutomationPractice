import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testAssignment 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("http://qaclickacademy.com/practice.php");
        System.out.println(driver.getTitle());
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        
        WebElement miniDriver=driver.findElement(By.id("gf-BIG"));
        System.out.println(miniDriver.findElements(By.tagName("a")).size()); 
        
       WebElement columnDriver=miniDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
       String openLinkInNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
       
       int noOfLinks=columnDriver.findElements(By.tagName("a")).size();
       for(int i=1;i<noOfLinks;i++)
        {
    	   columnDriver.findElements(By.tagName("a")).get(i).sendKeys(openLinkInNewTab);
           System.out.println(columnDriver.findElements(By.tagName("a")).get(i).getText());
        }
       Set<String>windowIDs=driver.getWindowHandles();
	   Iterator<String> IDs= windowIDs.iterator();
		while(IDs.hasNext())
		{
		 driver.switchTo().window(IDs.next());
		 System.out.println(driver.getTitle());
		}
       driver.quit();
	}
}