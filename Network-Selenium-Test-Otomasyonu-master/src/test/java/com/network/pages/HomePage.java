package com.network.pages;

import com.network.method.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;


import static com.network.driver.Driver.driver;

public class HomePage {
    By searchBox = By.id("search");


    Methods method = new Methods();
    public void isHomePage(){

        String URL = driver.getCurrentUrl(); Assertions.assertEquals(URL, "https://www.network.com.tr/" );
    }
    public void searchWord(){
        Assertions.assertTrue(method.isElementClickable(searchBox,10),"SEARCH BOX BULUNAMADI");
        method.clickElement(searchBox);
        method.sendText(searchBox,"ceket");
        driver.findElement(searchBox).submit();
    }

}
