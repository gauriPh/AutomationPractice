import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ArrayListSort {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/seleniumPractise/#/offers");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();
		//driver.findElement(By.cssSelector("tr th:nth-child(2)")).click();

		List<WebElement> actualNameList=driver.findElements(By.cssSelector("tr td:nth-child(2)"));
		ArrayList<String> actualOrder=new ArrayList<String>();
		ArrayList<String> expectedOrder=new ArrayList<String>();

		System.out.println("**************Actual Order**************");
		for(int i=0;i<actualNameList.size();i++)
		{
			actualOrder.add(actualNameList.get(i).getText());
			System.out.println(actualNameList.get(i).getText());
			expectedOrder.add(actualNameList.get(i).getText());
		}
		
		Collections.sort(expectedOrder);
		Collections.reverse(expectedOrder);

		System.out.println("**************Sorted Order**************");
		for(String s:expectedOrder )
			System.out.println(s);
		Assert.assertTrue(actualOrder.equals(expectedOrder));
		driver.quit();
	}

}
