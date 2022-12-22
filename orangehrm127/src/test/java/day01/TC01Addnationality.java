package day01;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TC01Addnationality {
	
	WebDriver driver ;
	String loginbutton="//button[@type='submit']";
	@Test
	public abstract void Addnationality();
	TC01Addnationality T1=new TC01Addnationality();
	T1.openchromeBrowser();
	T1.openorangeHRM();
	T1.login("Admin", "admin123");
	T1.Addnationality("indian1618");
	T1.logout();
	
	
}
    public void openchromeBrowser() {
    	System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
    	 }
    
    public void openorangeHRM() {
    	driver.get("https://opensource-demo.orangehrmlive.com/");

    	 }
    
    public void login(String username,String password) {
    	findElement1(By.name("username")).sendKeys(username);
		findElement1(By.name("password")).sendKeys(password);
		findElement1(By.xpath(loginbutton)).click();
		
    	
    	
    }
    	
    public void Addnationality1(String nationalitytext) {
    	findElement1(By.xpath("//span[text()='Admin']")).click();
    	findElement1(By.xpath("//a[text()='Nationalities']")).click();
    	findElement1(By.xpath("//button[text()=' Add ']")).click();
    	findElement1(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(nationalitytext);
    	findElement1(By.xpath("//button[text()=' Save ']")).click();
    	
    	
    }
    
    public void logout() {
    	
    	findElement1(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		findElement1(By.xpath("//a[text()='Logout']")).click();
		
		driver.close();
    	
    }
    
    
    
  
	}
    	public  WebElement findElement1(By by) throws Exception 
    	{

    		WebElement elem = driver.findElement(by);  
    		
    		if (driver instanceof JavascriptExecutor) 
    		{
    		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
    	 
    		}
    		return elem;
    	}

		
    
    
    
    
    
    