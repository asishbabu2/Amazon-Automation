import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AmazonTestNG {

	WebDriver driver;

	@BeforeClass
	@Parameters("url")
	public void start(String url) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("incognito");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		driver = new ChromeDriver(options);
		driver.navigate().to(url);
	}

	@Test
	@Parameters("search")
	public void addToCart(String search) throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement we = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		actions.click(we).perform();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(search);
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		driver.findElement(By.xpath(
				"//span[text()='Oneplus Buds Pro Bluetooth Truly Wireless in Ear Earbuds with mic (Matte Black)']"))
				.click();
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement we1 = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		js.executeScript("arguments[0].scrollIntoView();", we1);
		we1.click();
		Thread.sleep(5000);
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}
}
