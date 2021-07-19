package assignment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.assignment.utils.ConfigPropertyReader;


 

public class WheatherReporting {

	public static void main(String args[]){
	}
		public static HashMap<String, Integer> loginwheathersite(WebDriver driver) throws IOException, InterruptedException{
			HashMap<String, Integer> dataUI = new HashMap<String, Integer>();
			Properties prop = ConfigPropertyReader.readPropertiesFile("Config.properties");
		        String baseUrl = prop.getProperty("url");
		        WebDriverWait wait = new WebDriverWait(driver, 10);
		        driver.get(baseUrl);
		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Location']"))).click();
		        driver.findElement(By.xpath("//input[@placeholder='Search Location']")).sendKeys("Noida");
		        WebElement textbox = driver.findElement(By.xpath("//input[@placeholder='Search Location']"));
		        
		        textbox.sendKeys(Keys.ARROW_DOWN);
		        textbox.sendKeys(Keys.ENTER);

		        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='locations-list content-module']//a[1]"))).click();
					Thread.sleep(5000);
		        driver.switchTo().frame("google_ads_iframe_/6581/web/in/interstitial/admin/search_0");
		        driver.findElement(By.xpath("//div[@style='cursor: pointer;']")).click();
		        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cur-con-weather-card__cta"))).click();
		       Thread.sleep(2000);
		       String temp = driver.findElement(By.xpath("//div[@class='display-temp']")).getText();
		       int temperature  = Integer.parseInt(temp.substring(0,2));
		       int humidity = Integer.parseInt(driver.findElement(By.xpath("//div[@class='detail-item spaced-content']//div[text()='Humidity']//following-sibling::div")).getText().replaceAll("%", ""));
				dataUI.put("tempUI", temperature);
				dataUI.put("humidityUI", humidity);
		       return dataUI;
	
		 }

		
	
}

