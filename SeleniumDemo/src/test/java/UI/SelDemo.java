package UI;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelDemo {

	public static void main(String[] args) {
		
		ChromeDriver driver = new ChromeDriver();
//		FirefoxDriver driver = new FirefoxDriver();
//		EdgeDriver driver = new EdgeDriver();
		driver.get("https://www.google.com");
		
		/*
		 * DesiredCapabilities dc = new DesiredCapabilities();
		 * dc.setAcceptInsecureCerts(true);
		 * 
		 * ChromeOptions coptions = new ChromeOptions(); coptions.merge(dc);
		 * 
		 * WebDriver driver = new ChromeDriver(coptions);
		 * 
		 * 
		 * driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 * 
		 * driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Hello");
		 * 
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
		 * "//input[id='abc']"))).click();
		 * 
		 */
	}

}
