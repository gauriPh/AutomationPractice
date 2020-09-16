import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SpiceJetE2E {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@value='RoundTrip']")).click();
		//Thread.sleep(500L);
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).isSelected(), "Assertion False");
		driver.findElement(By.id("ctl00_mainContent_chk_IndArm")).click();
		WebElement Passanger= driver.findElement(By.id("divpaxinfo"));
		Passanger.click();
		Thread.sleep(2000L);
		for(int i=0;i<4;i++) 
				 driver.findElement(By.id("hrefIncAdt")).click();
		Assert.assertEquals(Passanger.getText(),"5 Adult");
		driver.findElement(By.id("hrefIncChd")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		Select sCurrency=new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		sCurrency.selectByIndex(3);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='PNQ']")).click();
		Thread.sleep(500L);
		driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
		Thread.sleep(500L);
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		//driver.quit();
	}

}
