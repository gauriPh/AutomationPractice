package TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class SeliniumTest
{
	ExtentReports rep;
	
	@BeforeTest
	public void extentReportConfig()
	{
		String Path=System.getProperty("user.dir")+"\\Results\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(Path);
		report.config().setReportName("ActionClass Report");
		
		rep=new ExtentReports();
		rep.attachReporter(report);
		rep.setSystemInfo("User", "Gauri");
	}

	@Test
	public void Test1()
	{
		ExtentTest test=rep.createTest("Test1");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").build().perform();
		driver.quit();
		test.fail("No match found");
		//test.addScreenCaptureFromBase64String(base64)
		rep.flush();
	}
	
	@Test
	public void Test2()
	{
		System.out.println("Test2");
	}

}
