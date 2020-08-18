import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class RegistrationTest {
	
	WebDriver driver;
	
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver", "D:\\Program Files\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://dev-1.clicktrans.pl/register-test/courier");
		driver.manage().window().maximize();
	}
	
	public void fillRegistrationForm() {
		
		driver.findElement(By.id("user_register_company_name")).sendKeys("Test sp. z o.o.");
		driver.findElement(By.id("user_register_email")).sendKeys("jtestowy@gmail.com");
		driver.findElement(By.id("user_register_name")).sendKeys("Jan Testowy");
		driver.findElement(By.id("user_register_phone")).sendKeys("576843567");
		driver.findElement(By.id("user_register_plainPassword")).sendKeys("Testowy123");
		driver.findElement(By.id("user_register_settings_agreementRegulations")).click();
		driver.findElement(By.id("user_register_settings_agreementPersonalData")).click();		
		driver.findElement(By.id("user_register_submit")).click();
	}
	
	public void isCorrect() {
		
		String expectedMessage = "OK - some registration logic is mocked";
		String message = driver.findElement(By.xpath("/html/body/div[6]/div")).getText();
		Assert.assertEquals(message, expectedMessage);
		System.out.println("Assert passed");
	}
	
	public void close(){
		
		driver.close();
	}
		
	public static void main(String[] args) throws InterruptedException {
		
		RegistrationTest obj = new RegistrationTest();
		obj.launchBrowser();
		obj.fillRegistrationForm();
		obj.isCorrect();
		Thread.sleep(1000);
		obj.close();
	}
}
