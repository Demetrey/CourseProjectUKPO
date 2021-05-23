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

/**
 *
 * @author 1
 */
public class WebUTest {
    WebDriver driver;
    
    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }
    
    /**
     * Тест перехода
     */
    @Test
    public void testGotoWebsite() {
        driver.navigate().to("http://localhost:8080/treepage");
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getPageSource()
                .contains("Balancing Binary Tree"));
        driver.close();
    }
    
    @Test
    public void testAdd() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
        driver.findElement(By.id("badd")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals("0"));
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
        driver.close();
    }
    
    @Test
    public void testClear() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals(""));
        driver.close();
    }
    
    @Test
    public void testBack() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("10");
        driver.findElement(By.id("badd")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
        driver.findElement(By.id("back")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals("0"));
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
        driver.close();
    }
    
    @Test
    public void testBalance() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
        driver.findElement(By.id("badd")).click();
        driver.findElement(By.id("add")).sendKeys("2");
        driver.findElement(By.id("badd")).click();
        driver.findElement(By.id("add")).sendKeys("3");
        driver.findElement(By.id("badd")).click();
        driver.findElement(By.id("balance")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals("000"));
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
        driver.close();
    }
    
    @Test
    public void testRemove() throws InterruptedException {
        driver.navigate().to("http://localhost:8080/treepage");
        driver.findElement(By.id("add")).sendKeys("1");
        driver.findElement(By.id("badd")).click();
        driver.findElement(By.id("del")).sendKeys("1");
        driver.findElement(By.id("bdel")).click();
        (new WebDriverWait(driver, 10)).until(
            (ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("bfactors"))
                .getAttribute("value").equals(""));
        Thread.sleep(1000);
        driver.findElement(By.id("clear")).click();
        driver.close();
    }
    
}
