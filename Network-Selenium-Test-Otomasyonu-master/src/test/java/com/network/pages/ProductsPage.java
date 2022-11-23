package com.network.pages;

import com.network.method.Methods;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.network.driver.Driver.driver;

public class ProductsPage {
    Methods method = new Methods();
    By endScroll = By.xpath("//button[@class=\"button -secondary -sm relative\"]");

    By productSize = By.cssSelector("label[for='size_46/6N']");

    By networkLogo = By.cssSelector(".img-fluid");
    //driver.findElement(By.cssSelector(".img-fluid")).click();

    By shoppingBag = By.cssSelector(".header__icon.-shoppingBag");
    //driver.findElement(By.cssSelector(".header__icon.-shoppingBag")).click();
     // By.className("\"header__basketTrigger js-basket-trigger -desktop\"");

    By clearBasket = By.cssSelector(".header__basketProductRemove");
    By approveToClear = By.cssSelector(".btn.-black.o-removeCartModal__button");

    By shoppingBasket = By.cssSelector(".header__icon.-shoppingBag");
             //driver.findElement(By.cssSelector(".header__icon.-shoppingBag")).click();

    By controlBasket = By.cssSelector(".header__emptyBasketText");


    public void moreProducts(){
        method.scrollElement(endScroll);
        method.waitSecond(1);
        method.clickElement(endScroll);
        method.waitSecond(2);

    }
    public void secondPageControl(){
        String URL = driver.getCurrentUrl(); Assertions.assertEquals(URL, "https://www.network.com.tr/search?searchKey=ceket&page=2" );
    }


    public void firstDiscountProduct(){

        method.scrollElement(productSize);
     //ürün ekleme
        driver.findElement(By.xpath("//*[@id=\"products\"]/div[3]/div[1]/div[51]/div/div[2]/a/h3")).click();
        String fiyat = driver.findElement(By.cssSelector(".product__price.-actual")).getText();

      //beden secme

        method.clickElement(productSize);
        method.waitSecond(2);

       //sepete git
        driver.findElement(By.cssSelector("button[class='product__button -addToCart btn -black']")).click();
        method.waitSecond(2);
    }


    public void checkTheValues(){


       // String oldPrice = driver.findElement(By.xpath("//div[@class='cartItem__prices']//span[@class='cartItem__price -old -labelPrice']")).getText();
        //String salePrice = driver.findElement(By.xpath("//div[@class='cartItem__prices']//span[@class='cartItem__price -sale']")).getText();
       // Assertions.assertEquals(oldPrice, salePrice);



        String oldPrice = driver.findElement(By.cssSelector(".header__basketModal.-priceValue")).getText();
        String salePrice = driver.findElement(By.cssSelector(".header__basketModal.-priceValue")).getText();
        String beden2 =driver.findElement(By.cssSelector("label[for='size_54/6N']")).getText();
        String beden1 =driver.findElement(By.cssSelector("label[for='size_54/6N']")).getText();

        Assertions.assertEquals(beden1,beden2 );
        Assertions.assertEquals(oldPrice,salePrice );

    }

    public void goBasket() {
        //sepete devam et
        driver.findElement(By.cssSelector(".button.-primary.header__basket--checkout.header__basketModal.-checkout")).click();

    }
    public void continueShopping()
    {
        driver.findElement(By.cssSelector(".continueButton.n-button.large.block.text-center.-primary")).click();

    }

    public void loginIdPassword(){

        String path = "C:\\Users\\NEO\\Desktop\\Network- Selenium Testi\\adsoyad.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line =br.readLine())!=null){

                String[] values =line.split(",");

                WebElement eMail = driver.findElement(By.cssSelector("#n-input-email"));
                eMail.click();
                eMail.sendKeys(values[0]);

                method.waitSecond(2);

                WebElement code =driver.findElement(By.cssSelector("#n-input-password"));
                code.click();
                code.sendKeys(values[1]);

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);}


        //Sign in
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();


    }

    public void clickLogo(){
        method.clickElement(networkLogo);
        method.waitSecond(2);
    }

    public void clickBag(){
        method.clickElement(shoppingBag);
        method.waitSecond(2);
    }

    public void clearShoppingBasket(){
        method.clickElement(clearBasket);
        method.waitSecond(2);
        method.clickElement(approveToClear);
    }

    public void controlTheShoppingBasket(){
        method.clickElement(shoppingBasket);
        Assertions.assertTrue(method.isElementVisible(controlBasket,3), "SEPETİNİZ BOŞ DEĞİL");
    }


}


