import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableAssignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[text()='Practice']")).click();
		WebElement table=driver.findElement(By.id("product"));
		
		int columnCount=table.findElements(By.tagName("th")).size();
		System.out.println("No. of Rolumns = " + columnCount);
		
		int rowCount=table.findElements(By.tagName("tr")).size();
		System.out.println("No. of Rows = " + rowCount);
		
		WebElement row2=table.findElements(By.tagName("tr")).get(2);
        for(int i=0; i<columnCount; i++)
        	System.out.println(row2.findElements(By.tagName("td")).get(i).getText());
		
		driver.quit();
	}

}
