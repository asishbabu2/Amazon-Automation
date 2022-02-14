package test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import objects.HomePage;
import objects.AddToCartPage;
import objects.AmazonSignIn;

public class AmazonTest {
	WebDriver driver;

	@BeforeClass
	@Parameters("url")
	public void driverInstance1(String url) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you want to use incognito mode ? Select your answer ");
		System.out.println("1.Yes");
		System.out.println("2.No");
		int answer = sc.nextInt();
		switch (answer) {
		case 1:
			options.addArguments("incognito");
			break;
		case 2:
			break;
		default:
			System.out.println("Invalid Answer");
			System.exit(0);
		}
		driver = new ChromeDriver(options);
		driver.navigate().to(url);
	}

	@Test(priority = 0)
	@Parameters("email")
	public void email(String email) {
		AmazonSignIn obj = new AmazonSignIn(driver);
		obj.emailId(email);
	}

	@Test(priority = 1)
	@Parameters("Password")
	public void password(String Password) {
		AmazonSignIn obj = new AmazonSignIn(driver);
		obj.passWord(Password);
	}

	@Test(priority = 2)
	@Parameters("search")
	public void HomePageOperation1(String search) {
		HomePage page1 = new HomePage(driver);
		page1.SearchInAmazon(search);
	}

	@Test(priority = 3)
	public void HomePageOperation2() {
		HomePage objectrepo = new HomePage(driver);
		objectrepo.selectProduct();
	}

	@Test(priority = 4)
	public void addToCartOperation() {
		AddToCartPage page2 = new AddToCartPage(driver);
		page2.addToCart();
	}

	@AfterClass
	public void stop() {
		driver.quit();
	}
}
