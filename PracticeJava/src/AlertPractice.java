import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPractice {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		WebElement CheckPoint=driver.findElement(By.xpath("//input[@value='option1']"));
		for(int i=0;i<2;i++)
		{
			CheckPoint.click();
		    if(CheckPoint.isSelected())
			  System.out.println("Option 1 is successfully checked");
		    else
			  System.out.println("Option 1 is successfully unchecked");
		}
		
		System.out.println("This web page contains "+driver.findElements(By.xpath("//input[@type='checkbox']")).size()+" Checkbox(es)");
		driver.quit();
	}

}
