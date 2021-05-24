/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 *
 * @author 1
 */
public class WebUTest {
    WebDriver driver;
    
    @Before
    public void setUp() {
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("--headless", "window-size=1024,768", "--no-sandbox");
	driver = new ChromeDriver(ChromeOptions);
    }
    
    /**
     * Тест перехода
     */
    @Test
    public void testGotoWebsite() {
        driver.navigate().to("http://localhost:8080/treepage");
        (new WebDriverWait(driver, 20)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource()
                .contains("Balancing Binary Tree"));
        driver.close();
    }
    
    @Test
    public void testAdd() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        (new WebDriverWait(driver, 30)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals("0"));
        Thread.sleep(1000); 
        driver.findElement(By.id("clear")).click();
        Thread.sleep(1000);
        driver.close();
    }
    
    @Test
    public void testClear() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000); 
        driver.findElement(By.id("clear")).click();
        Thread.sleep(1000);
        (new WebDriverWait(driver, 30)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals(""));
        driver.close();
    }
    
    @Test
    public void testBack() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("10");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
	Thread.sleep(1000);
        driver.findElement(By.id("back")).click();
        Thread.sleep(1000);
        (new WebDriverWait(driver, 30)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals("0"));
        driver.findElement(By.id("clear")).click();
        Thread.sleep(1000);
        driver.close();
    }
    
    @Test
    public void testBalance() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add")).sendKeys("2");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("add")).sendKeys("3");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("balance")).click();
        Thread.sleep(1000);
        (new WebDriverWait(driver, 30)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals("000"));
        driver.findElement(By.id("clear")).click();
        Thread.sleep(1000);
        driver.close();
    }
    
    @Test
    public void testRemove() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
	Thread.sleep(1000);
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("del")).sendKeys("1");
	Thread.sleep(1000);
        driver.findElement(By.id("bdel")).click();
        Thread.sleep(1000);
        (new WebDriverWait(driver, 30)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals(""));
        driver.findElement(By.id("clear")).click();
        Thread.sleep(1000);
        driver.close();
    }
    
}
