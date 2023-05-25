package webpages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmailInboxPage {

	@FindBy(xpath="*//div[@class=\"choose-inbox\"]/input[@placeholder=\"anything\"]")
	private WebElement txtemail;
	@FindBy(xpath="*//div[@class=\"choose-inbox\"]/button")
	private WebElement btnClick;
	@FindBy(xpath="*//strong[text()=\"noreply.practice@expandtesting.com\"]")
	private WebElement mail;
	
	@FindBy(xpath="*//div[@class=\"ng-binding ng-scope\"]/div")
	private WebElement textinMail; 
	
	WebDriver driver;
	public EmailInboxPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public  String mailaccess()
	{
	
		txtemail.clear();
		txtemail.sendKeys("abc");
		btnClick.click();
		mail.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(textinMail));
		String passwordlink=textinMail.getText();
		String token=passwordlink.split("reset-password/")[1];
		System.out.println("password token:"+token);
		
		return token;
	}
	
}
