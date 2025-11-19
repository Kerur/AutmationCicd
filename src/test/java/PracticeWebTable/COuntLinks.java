package PracticeWebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class COuntLinks {

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		int numOfLinks = driver.findElements(By.tagName("a")).size();
		System.out.println("Total num of links in web page : " + numOfLinks);
		//within footer
	int numOfLinkWithinFooter = driver.findElements(By.xpath("//div[@id='gf-BIG']/table/tbody/tr/td/ul/li[1]/following-sibling::li")).size();
        System.out.println("numOfLinkWithinFooter " + numOfLinkWithinFooter);
	}

}
