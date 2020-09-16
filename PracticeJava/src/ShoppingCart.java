import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCart 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		String[] requiredProducts= {"Cucumber","Beetroot","Brinjal"};
		SelectItems(driver,requiredProducts);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.className("promoBtn")).click();
				
		WebDriverWait wx=new WebDriverWait(driver,3);
		wx.until(ExpectedConditions.invisibilityOfElementLocated(By.className("promoInfo")));
		System.out.println(driver.findElement(By.className("promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		
		//Select countrySelect=new Select(driver.findElement(By.));
		
		//driver.quit();
	}
	
    public static void SelectItems(WebDriver driver,String[] requiredProducts)
    {
    	List<WebElement> productList=driver.findElements(By.className("product-name"));
	    List<String> requiredProductNames=Arrays.asList(requiredProducts);
	    int j=0;
	    
		for(int i=0; i<productList.size();i++)
		{		
			String currentProductFullName=productList.get(i).getText();
			String[] currentProductName=currentProductFullName.split(" ");
					
			if(requiredProductNames.contains(currentProductName[0]))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if(j==requiredProductNames.size())
					break;
			}	
		}
    }
}
