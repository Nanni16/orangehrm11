package day01;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC01Addskills2 {
	
	WebDriver driver ;
	String loginbutton="//button[@type='submit']";
	
	@Test
	
	public void skilltest() throws Exception {
	TC01Addskills2 T1=new TC01Addskills2 ();
	T1.openchromeBrowser();
	T1.openorangeHRM();
	T1.loginpage("Admin", "admin123");
	T1.addskills("java11", "java12Desrc");
    T1.logout();
			
		
	}

	public void openchromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
	}
	
		public void openorangeHRM () {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		}
	
	public void loginpage(String username,String password) throws Exception {
		
		findElement(By.name("username")).sendKeys(username);
		findElement(By.name("password")).sendKeys(password);
		findElement(By.xpath(loginbutton)).click();
		
	}
	
	public void addskills(String skillname,String skilldescr) throws Exception {
		
		findElement(By.xpath("//span[text()='Admin']")).click();
		findElement(By.xpath("//span[text()='Qualifications ']")).click();
		findElement(By.xpath("//a[text()='Skills']")).click();
		findElement(By.xpath("//i[@class='oxd-icon bi-plus oxd-button-icon']")).click();
	    findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(skillname);
	    findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(skilldescr);
	    findElement(By.xpath("//button[@type='submit']")).click();   
              
	}
	
	
	public void logout () throws Exception {
		
		findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		findElement(By.xpath("//a[text()='Logout']")).click();
		
		driver.close();
	}
	
	public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	} 
}

