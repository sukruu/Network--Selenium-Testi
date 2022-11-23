package com.network.driver;

import com.network.testlogs.TestResultLogger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@ExtendWith(TestResultLogger.class)
public class Driver {
    public static WebDriver driver;
    @BeforeAll
    public static void driverPlace(){

        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
    }
    @BeforeEach
    public void driverBegin(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.network.com.tr/");
    }
    @AfterAll
    public static void finishtime(){
        driver.quit();

    }
}
