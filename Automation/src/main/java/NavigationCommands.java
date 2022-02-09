import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationCommands {

	
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String url = "http://the-internet.herokuapp.com/";
		driver.navigate().to(url);
		driver.manage().window().maximize();
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		WebElement we = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='A/B Testing']")));
//		we.click();
//		Thread.sleep(3000);
//		driver.navigate().back();
//		Thread.sleep(3000);
//		driver.navigate().forward();
//		Thread.sleep(3000);
//		driver.navigate().refresh();
//		Thread.sleep(3000);
//		driver.close();
		
		String main = driver.getTitle();
		List<WebElement> li = driver.findElements(By.tagName("a"));
		
		for(WebElement w : li)
		{
			w.click();
			String test = driver.getTitle();
			if(test.equals(main))
			{
				System.out.println(w.getText() + " is not working ");
			}
			else
			{
				driver.navigate().back();
			}
		}
		driver.close();
	}

}
