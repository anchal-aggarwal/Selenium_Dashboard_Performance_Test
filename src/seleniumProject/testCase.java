package seleniumProject;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;

public class testCase {

	public static void main(String[] args) {
		for(int i=0;i<2;i++) {
	
		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
        capabilities.setCapability("chrome.binary", "/Users/anchalaggarwal/Downloads/Chromium_OSX_74.0.3729.169.dmg");
		System.setProperty("webdriver.chrome.driver","/Users/anchalaggarwal/bin/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dashboard.stanzaliving.com");
		//Login Page
		WebElement email = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/form/div/div[2]/div/div[1]/input"));
		WebElement password = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/form/div/div[2]/div/div[2]/input"));
     	email.sendKeys("9193624936");
		password.sendKeys("ANCH9193");
//		email.sendKeys(args);
//		password.sendKeys(args);
		WebElement login=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/form/div/div[3]/div/button"));
		login.click();
		driver.manage().window().maximize();
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			File dest= new File("/Users/anchalaggarwal/Desktop/seleniumProject/screenshot_"+timestamp()+".png");
			FileUtils.copyFile(src, dest);
			
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		final JavascriptExecutor js = (JavascriptExecutor) driver;
	    // time of the process of navigation and page load
	    double loadTime = (Double) js.executeScript(
	        "return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000" + "\n");
	    System.out.print(loadTime + " seconds" + "\n" + "\n" ); // 5.15 seconds
	}
	}
	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
		
		
		
	}


