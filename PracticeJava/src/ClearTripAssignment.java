import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ClearTripAssignment {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(1000L);
		Select Adults= new Select(driver.findElement(By.id("Adults")));
        Adults.selectByIndex(3);	
		Select Childs= new Select(driver.findElement(By.id("Childrens")));
		Childs.selectByVisibleText("1");
		driver.findElement(By.cssSelector(".icon.ir.datePicker")).click();
		Thread.sleep(2000L);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).sendKeys(Keys.ENTER);;
		driver.findElement(By.xpath("//a[@id='MoreOptionsLink']/strong/i")).click();
		Select customerClass=new Select(driver.findElement(By.id("Class")));
		customerClass.selectByValue("Business");
		driver.findElement(By.xpath("//input[@id='AirlineAutocomplete']")).sendKeys("Spice Jet");
		driver.findElement(By.id("SearchBtn")).click();
		String errorMsg=driver.findElement(By.id("homeErrorMessage")).getText();
		System.out.println(errorMsg);
		driver.quit();
	}

}
