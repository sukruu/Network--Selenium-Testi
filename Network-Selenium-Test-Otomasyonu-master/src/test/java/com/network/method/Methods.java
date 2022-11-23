package com.network.method;

import com.network.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;


public class Methods {

    public WebDriver driver;

    public Methods(){
        this.driver= Driver.driver;
    }
    FluentWait<WebDriver> fluentWait;
    WebElement element;
    public void findObject(By by){ // Selenium'da tanımlı bir methodu kendi metodumuzun içerine yerleştirdik. // Driver elementi buluyor
        driver.findElement(by);
    }
    public void clickElement(By by){ // Bizim oluştyurduğumuz methodumuz // Driver element'e klick yapıyor
        driver.findElement(by).click();
    }
    public void clear(By by){  // Driver elementte yazı varsa siliyor
        driver.findElement(by).clear();
    }
    public void sendText(By by,String text){ // Driver element'e text yolluyor
        driver.findElement(by).sendKeys(text);
    }
    public void scrollElement(By by){  // Driver element'e scrolliyor
        element = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.scrollToElement(element).perform();
       // new Actions(driver).scrollToElement(element).perform();
    }
    public void hoverElement(By by) {  // Driver element'e mouse'u hoverliyor.
        Actions actions = new Actions(driver);
        element = driver.findElement(by);
        actions.moveToElement(element).build().perform();
    }
    public void waitMilisecond(long ms){
        try{
            Thread.sleep(ms);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void waitSecond(long second){
        waitMilisecond(second*1000);
    }
    public FluentWait<WebDriver> setFluentWait(long timeout){

        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeout))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class);
    }
    public boolean isElementVisible(By by,long timeout){
        try {
            setFluentWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public boolean isElementClickable(By by,long timeout){
        try {
            setFluentWait(timeout).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public List<WebElement> findAllProduct(By locator) {
        return driver.findElements(locator);
    }
    public void randomSelect(By locator) { // random seçme
        Random rand = new Random();
        findAllProduct(locator).get(rand.nextInt(findAllProduct(locator).size())).click();
    }
}

