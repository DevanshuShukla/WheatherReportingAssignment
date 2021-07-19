package assignment;



import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.DriverManageFactory;
import TestBase.DriverManager;
import TestBase.DriverType;

public class Tests {
DriverManager driverManager;
WebDriver driver;
HashMap<String, Integer> dataUI;
HashMap<String, Integer> dataAPI;


@Test(priority =1)
public void loginToWheather() throws IOException, InterruptedException{
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/src/test/resources/selenium-driver//chromedriver.exe");
	driverManager = DriverManageFactory.getDriverManager(DriverType.CHROME);
	driver = driverManager.getWebDriver();
	dataUI = WheatherReporting.loginwheathersite(driver);
}


@Test
public void accuWheatherAPI(){
	 dataAPI = AccuWheatherAPIAction.accuwheather();
  
}

@Test(priority =3)
public void validateTemp(){
	int tempDifference = dataUI.get("tempUI") - dataAPI.get("tempAPI");
	int humidityDifference = dataUI.get("humidityUI") - dataAPI.get("humidityAPI");
	
	boolean flag = tempDifference < 2 && humidityDifference < 10;
	Assert.assertTrue(flag, "Failed due to temp difference");
	
}



}
