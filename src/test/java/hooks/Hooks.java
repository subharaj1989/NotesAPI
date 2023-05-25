package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Logging;

public class Hooks {
	
	public static WebDriver driver;
	//@Before("@ResetToken")
	public static void driversetup()
	{
		WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
		driver.get("https://mailsac.com/");
	}
	
	@Before
	public void loginFile()
	{
		Logging.logtoFile();
	}
	
	@After("@resetPassword or @ResetToken")
	public void teardown()
	{
		driver.close();
	}
	
}
