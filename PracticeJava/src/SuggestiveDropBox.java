import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SuggestiveDropBox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Boolean result=false;
		int i=0;

		WebElement PlaceFrom=driver.findElement(By.id("fromPlaceName"));
		PlaceFrom.sendKeys("BENG");
		
		while(result==false)
		{
			i++;
			JavascriptExecutor js= (JavascriptExecutor)driver;
			String script="return document.getElementById(\"fromPlaceName\").value;";
			String text=(String) js.executeScript(script);
			System.out.println(text);
			if(text.contains("AIRPORT"))
			{
				result=true;
				System.out.println("ElementFoundSuccessfully");
				System.out.println("Option Verified");
				break;
			}
			if(i==10)
			{
				System.out.println("ElementNotFound");
				break;
			}
			PlaceFrom.sendKeys(Keys.ARROW_DOWN);
		}
		driver.quit();
	}

}
