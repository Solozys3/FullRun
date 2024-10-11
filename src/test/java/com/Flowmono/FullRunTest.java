package com.Flowmono;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
// import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FullRunTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver-win64\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER); // Eager loading strategy
        driver = new ChromeDriver(options);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait
        driver.get("https://www.flowmono.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(60)); // Increased wait time
    }

    @Test
    public void TestURL() throws InterruptedException {
        WebElement popUpImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"announcement-pop-up\"]/div/img")));
        popUpImage.click();
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        driver.findElement(By.id("mat-input-0")).sendKeys("solomon.sunday@reventtechnologies.com");
        driver.findElement(By.id("mat-input-1")).sendKeys("Solomonsunday@3");
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
        wait.until(ExpectedConditions.urlContains("/dashboard"));
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[contains(text(),'Sign Document')]")).click(); // Sign document
        driver.findElement(By.xpath("//p[contains(text(),'Sign With Others')]")).click();  // Sign With Others
        wait.until(ExpectedConditions.urlContains("/document/e/setup?signType=multiple"));
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/button")).click();  // Add New Documents
        driver.findElement(By.xpath("//p[contains(text(),'Upload from computer')]"));  // Upload Document

        // Upload the file
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\HP\\Desktop\\Daily Report\\nestle.png");
        Thread.sleep(2000);

        WebElement dropdownArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-select-value-1\"]")));
        if (dropdownArrow.isDisplayed() && dropdownArrow.isEnabled()) {
            dropdownArrow.click();
        }
		        
        // Wait for the 'General' option and click it
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-option//span[contains(text(), 'General')]"))).click();
		Thread.sleep(500);

        driver.findElement(By.id("mat-input-5")).sendKeys("realsolo03@yopmail.com");
        driver.findElement(By.id("mat-input-6")).sendKeys("Solomon");
        driver.findElement(By.id("mat-input-7")).sendKeys("Sunday");
        driver.findElement(By.xpath("//*[@id=\"mat-select-4\"]/div/div[2]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"mat-option-3\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/div[2]/button")).click();
        Thread.sleep(10000);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"editor-controls-toolbar\"]/div[3]/div/div/div[2]/div[1]/div/div/app-svg/svg"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='actor-menu-toggler-text' and text()=' Assign recipient ']"))).click();
        driver.findElement(By.xpath("//p[@class='actor-menu-toggler-text' and text()=' Assign recipient ']")).click();
        driver.findElement(By.xpath("//*[@id=\"editor-top-bar\"]/div[3]/button[5]")).click();
    }
}
