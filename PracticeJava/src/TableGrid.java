import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableGrid
{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\phoph\\Selenium-workspace\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/22581/aus-vs-nz-1st-test-new-zealand-tour-of-australia-2019-20");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		int sum=0;
		WebElement firstInning=driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		int count=firstInning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();
		for(int i=0; i<count-2; i++)
		{
			String batsmanScore=firstInning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
			int runs=Integer.parseInt(batsmanScore);
			sum=sum+runs;
		}
		
		String extras=firstInning.findElement(By.xpath("//div[text()='Extras']/following-sibling::div")).getText();
		int extraRuns=Integer.parseInt(extras);
		int finalScore=sum+extraRuns;
		
		String total=firstInning.findElement(By.xpath("//div[text()='Total']/following-sibling::div")).getText();
		int TotalScore=Integer.parseInt(total);
		
		if(finalScore==TotalScore)
				System.out.println("Total Score matches with final score as " + finalScore );
		else
				System.out.println("Total Score doesn't matches with final score as " + finalScore );			
		driver.quit();
	}

}
