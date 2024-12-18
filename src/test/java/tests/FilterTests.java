package tests;

import BaseTest.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FilterTests extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    private static final Logger logger = LogManager.getLogger(FilterTests.class);
    @Test
    public void testSortPrices(){
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user").enterPassword("secret_sauce").clickOnLogin();
        productsPage = new ProductsPage(driver);
        List<String> productPriceList = productsPage.getProductPricesList();
        logger.info("Before sorting :" + productPriceList);
        productsPage.sortBy("Price (low to high)");
        List<String> sortedProductPriceList = productsPage.getProductPricesList();
        ArrayList<String>sortedList = new ArrayList<>(sortedProductPriceList);
        logger.info("After sorting :" + sortedProductPriceList);
        logger.info(sortedList);
        Assert.assertEquals(sortedProductPriceList,sortedList);
    }
}
