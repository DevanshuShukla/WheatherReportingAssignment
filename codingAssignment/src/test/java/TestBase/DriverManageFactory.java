package TestBase;

public class DriverManageFactory {

	public static DriverManager getDriverManager(DriverType type){
		DriverManager driverManager = null;
		switch(type){
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
		}
		return driverManager;
	}
}
