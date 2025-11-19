package PracticeWebTable;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
	public static void main(String[] str) throws MalformedURLException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//int count = driver.findElements(By.tagName("a")).size();
		//System.out.println(count);
		List<WebElement> links =driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		for(WebElement allLinks : links) {
			String url = allLinks.getAttribute("href");
			HttpURLConnection conn =(HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int responseCode =conn.getResponseCode();
			System.out.println(responseCode);
			if(responseCode>400)
			{
				System.out.println("Link status is " + responseCode + allLinks.getText());
			}
		}
		
          List<WebElement> allLinks=  driver.findElements(By.xpath("//li[@class='gf-li']/h3/a"));	
          for(WebElement link : allLinks)
          {
        	 String hrefs = link.getAttribute("href");
        	 HttpURLConnection conn = (HttpURLConnection) new URL(hrefs).openConnection();
        	 conn.setRequestMethod("HEAD");
        	 conn.connect();
        	int respensoCode = conn.getResponseCode();
        	
        	if(respensoCode>400) {
        		System.out.println("this link is broken : "+ link.getText());
        	}
          }
	}

}
