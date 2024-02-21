package test;

import base.TestBase;
import data.provider.ProductData;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main extends TestBase {

    @Test(dataProvider = "productDataFromJSON", dataProviderClass = ProductData.class)
    public void checkOutWithJSON(String userName, String passWord, String nameProduct) throws Exception {
        String lastName = "Le";
        String firstName = "Quang";
        String postalCode = "7000";
        LoginPage loginPage = new LoginPage(this._driver);
        boolean isCheckout = loginPage.login(userName, passWord).selectProduct(nameProduct).addProductToCart(nameProduct).get_header()
                .navigationToCart()
                .StartCheckOut()
                .insertInformation(firstName, lastName, postalCode)
                .finishCheckout()
                .isCheckout("Thank you for your order!");
        Assert.assertTrue(isCheckout);
    }
    @Test(dataProvider = "productDataFromJSON",dataProviderClass = ProductData.class)
    public void removeProductWithExcel(String userName,String passWord, String nameProduct) throws Exception {
        LoginPage loginPage = new LoginPage(this._driver);
        boolean remove = loginPage.login(userName,passWord).selectProduct(nameProduct)
                .addProductToCart(nameProduct).get_header()
                .navigationToCart()
                .removeItemByName(nameProduct)
                .isCartEmpty();

        Assert.assertTrue(remove);

    }
    @Test(dataProvider = "productDataFromExcel", dataProviderClass = ProductData.class)
    public void checkOutWithExcel(String userName, String passWord, String nameProduct) throws Exception {
        String lastName = "Le";
        String firstName = "Quang";
        String postalCode = "7000";
        LoginPage loginPage = new LoginPage(this._driver);
        boolean isCheckout = loginPage.login(userName, passWord)
                .selectProduct(nameProduct)
                .addProductToCart(nameProduct).get_header()
                .navigationToCart()
                .StartCheckOut()
                .insertInformation(firstName, lastName, postalCode)
                .finishCheckout()
                .isCheckout("Thank you for your order!");
        Assert.assertTrue(isCheckout);
    }

    @Test(dataProvider = "productDataFromExcel",dataProviderClass = ProductData.class)
    public void removeProduct(String userName,String passWord, String nameProduct) throws Exception {
        LoginPage loginPage = new LoginPage(this._driver);
        boolean remove = loginPage.login(userName,passWord).selectProduct(nameProduct)
                        .addProductToCart(nameProduct).get_header()
                        .navigationToCart()
                        .removeItemByName(nameProduct)
                        .isCartEmpty();

        Assert.assertTrue(remove);

    }

}
