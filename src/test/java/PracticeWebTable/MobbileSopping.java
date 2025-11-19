package PracticeWebTable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MobbileSopping {
	
	public static void main(String[] arg) {
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	driver.manage().window().maximize();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	Assert.assertEquals("LoginPage Practise | Rahul Shetty Academy", driver.getTitle()) ;
	System.out.println("Current URL :" + 
	driver.getCurrentUrl());
	driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
	driver.findElement(By.id("password")).sendKeys("learning");
	WebElement userRadio = driver.findElement(By.xpath("//input[@value='user']"));
	System.out.println(userRadio.isSelected());
	userRadio.click();
	
	Actions act = new Actions(driver);
	
	act.moveToElement(driver.findElement(By.xpath("//div[@class='modal-content']")));
	System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']/p")).getText());
	wait.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn"))).click();

	
	System.out.println(userRadio.isSelected());
	
	WebElement dropDown = driver.findElement(By.xpath("//select [@class='form-control']"));
	Select select = new Select(dropDown);
	select.selectByValue("consult");
	
	driver.findElement(By.xpath("//input [@name='terms']")).click();
	String tearmsConditionsText = driver.findElement(By.xpath("//label[@for='terms']")).getText();
	System.out.println(tearmsConditionsText);
	
	}

	private static Action Action(WebDriver driver) {
		// TODO Auto-generated method stub
		return null;
	}
	
 
}
