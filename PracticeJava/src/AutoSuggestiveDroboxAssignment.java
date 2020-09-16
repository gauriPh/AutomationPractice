import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDroboxAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		driver.findElement(By.xpath("//a[text()='Practice']")).click();
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		int i=0;
		String DesiredCountry="UK";
		Boolean result=false;
		JavascriptExecutor js= (JavascriptExecutor)driver;

		WebElement target=driver.findElement(By.id("autocomplete"));
		target.sendKeys("UNI");
		while(result==false)
		{
			i++;
			target.sendKeys(Keys.ARROW_DOWN);
			String script="return document.getElementById(\"autocomplete\").value;";
			String text=(String) js.executeScript(script);
			System.out.println(text);
			if(text.contains(DesiredCountry))
			{
				result=true;
				System.out.println("Desired Country Selected Successfully as " + DesiredCountry );
				System.out.println("Option Verified");
				break;
			}
			if(i==10)
			{
				System.out.println("DesiredCountry Not Found in list");
				break;
			}
			
		}	
		driver.quit();
	}

}
