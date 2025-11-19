package PracticeWebTable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeTWO {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//checking checkbox of option3
		driver.findElement(By.id("checkBoxOption3")).click();
		String checkBoxValue = driver.findElement(By.xpath("//label[@for='honda']")).getText();
		System.out.println(checkBoxValue);
		//sending same check box value to drop down
		WebElement dropDown =driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropDown);
		select.selectByVisibleText(checkBoxValue);
		
		//giving input to alert text box
		driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys(checkBoxValue);
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		driver.switchTo().alert().accept();
		
		//scrool down the web page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		
		//getting number of rows from table
		List<WebElement> list = driver.findElements(By.xpath("//table[@id='product' and @class='table-display']/tbody/tr"));
		System.out.println("num of rows " + list.size());
		
		//num of columns
		int coulnmSize = driver.findElements(By.xpath("//table[@id='product' and @class='table-display']/tbody/tr/td")).size();
		System.out.print(coulnmSize);
		
		//handling windows
		driver.findElement(By.id("opentab")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentId = iterator.next();
		String childId=iterator.next();
		driver.switchTo().window(childId);
		//clicking new tab button
		driver.findElement(By.xpath("//a[@class='main-btn' and text()='Access all our Courses']")).click();
		driver.switchTo().window(parentId);
		
	}

}
