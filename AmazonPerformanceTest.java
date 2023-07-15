package java_selenium_project_pack1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonPerformanceTest {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VINAYAK\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Set the maximum time to wait for elements to load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Measure Page Load Time
        long pageLoadStartTime = System.currentTimeMillis();

        // Launch the Amazon 
        driver.get("https://www.amazon.com");

        long pageLoadEndTime = System.currentTimeMillis();
        long pageLoadTime = pageLoadEndTime - pageLoadStartTime;
        System.out.println("Page Load Time: " + pageLoadTime + " milliseconds");

        // Search for a Product
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone");
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Measure Response Time
        long responseStartTime = System.currentTimeMillis();

        // Perform specific actions for response time testing
        WebElement firstProduct = driver.findElement(By.cssSelector(".sg-col-inner"));
        firstProduct.click();

        long responseEndTime = System.currentTimeMillis();
        long responseTime = responseEndTime - responseStartTime;
        System.out.println("Response Time: " + responseTime + " milliseconds");

        // Simulate Concurrent User Behavior (using Thread.sleep for demonstration purposes)
        int concurrentUsers = 10;

        for (int i = 0; i < concurrentUsers; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                	WebDriver  userDriver = new ChromeDriver();
                    userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    userDriver.get("https://www.amazon.com");
                    // Perform actions as a concurrent user
                   // ...
                    userDriver.quit();
                }
            });
            thread.start();
        }

        // Stress Testing (increase load gradually)
        int rampUpTime = 5; // Time to start all threads (in seconds)
        int maxUsers = 100; // Maximum number of concurrent users
        int increment = 10; // Number of users to add per increment

        for (int i = 0; i <= maxUsers; i += increment) {
            // Start 'increment' number of threads every 'rampUpTime' seconds
            for (int j = 0; j < increment; j++) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        WebDriver userDriver = new ChromeDriver();
                        userDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        userDriver.get("https://www.amazon.com");
                        // Perform actions under stress testing
                        // ...
                        userDriver.quit();
                    }
                });
                thread.start();
            }

            try {
                TimeUnit.SECONDS.sleep(rampUpTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Close the browser
        driver.quit();
    }
}

