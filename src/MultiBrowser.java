import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowser {
    static WebDriver driver;
    static String baseUrl = "https://www.saucedemo.com";
    static String browser = "chrome";

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.out.println("Browser not found");
        }
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        System.out.println("Title : " + driver.getTitle());
        System.out.println("CurrentURL : " + driver.getCurrentUrl());
        System.out.println("Pagesource : " + driver.getPageSource());
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("prime123@gmail.com");
        WebElement passWord = driver.findElement(By.id("password"));
        passWord.sendKeys("prime123");
        driver.close();

    }
}