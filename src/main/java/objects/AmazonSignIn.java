package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonSignIn {
	WebDriver driver;

	public AmazonSignIn(WebDriver driver) {
		this.driver = driver;
	}

	By signinButton = By.xpath("(//*[text()='Hello, Sign in'])[1]");
	By signin = By.xpath("(//*[text()='Sign in'])[1]");
	By emailID = By.xpath("//input[@name='email']");
	By continueButton = By.xpath("//input[@id='continue']");
	By password = By.xpath("//input[@name='password']");
	By submit = By.xpath("//input[@id='signInSubmit']");

	public void emailId(String email) {
		driver.findElement(signinButton).click();
		driver.findElement(emailID).sendKeys(email);
		driver.findElement(continueButton).click();
	}

	public void passWord(String Password) {
		driver.findElement(password).sendKeys(Password);
		driver.findElement(submit).click();

	}

}
