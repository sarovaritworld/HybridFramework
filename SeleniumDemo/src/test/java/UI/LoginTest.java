package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {

    public static String browser = "chrome"; // Set browser type here (chrome, firefox, edge)
    public static WebDriver driver;

    public static void main(String[] args) {
        setUpDriver();
        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();
        driver.getCurrentUrl();
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        // Close the browser after the test
//        driver.quit();
    }

   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static void setUpDriver() {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Browser not supported!");
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
