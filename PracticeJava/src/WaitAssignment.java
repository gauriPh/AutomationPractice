import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitAssignment 
{

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();
		WebDriverWait wx=new WebDriverWait(driver,5);
		wx.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='results']")));
			
		System.out.println(driver.findElement(By.xpath("//div[@id='results']")).getText());
		driver.quit();

	}

}
