package com.network.test;
import com.network.driver.Driver;
import com.network.pages.HomePage;
import com.network.pages.ProductsPage;
import org.junit.jupiter.api.Test;

public class NetworkTest extends Driver {
    HomePage homePage;
    ProductsPage productsPage;


    @Test
    public void networkTest(){
        homePage = new HomePage();
        productsPage = new ProductsPage();

        homePage.isHomePage();
        homePage.searchWord();

        productsPage.moreProducts();
        productsPage.secondPageControl();
        productsPage.firstDiscountProduct();
        productsPage.checkTheValues();
        productsPage. goBasket();
        productsPage.continueShopping();
        productsPage.loginIdPassword();
        productsPage.clickLogo();
        productsPage.clickBag();
        productsPage.clearShoppingBasket();
        productsPage.controlTheShoppingBasket();

    }

}
