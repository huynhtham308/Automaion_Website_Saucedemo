package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import java.util.List;

public class CartPage extends BasePage {

    private By btnCheckout = By.xpath("//*[contains(@class, 'checkout_button')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    By lstCartItem = By.className("cart_item");


    public CheckOutStepOnePage StartCheckOut() throws Exception {
        this.get_actionkeyword().click(btnCheckout);
        return new CheckOutStepOnePage(this._driver);
    }

    public CartPage removeItemByName(String nameProduct) {
//        List<WebElement> cartItem = this._driver.findElements(lstCartItem);
        String btnRemoveProductXPath = String.format("//*[text() = '%s']//../..//button", nameProduct);
        try {
          this.get_actionkeyword().click(By.xpath(btnRemoveProductXPath));

        } catch (NoSuchElementException elementException) {
            elementException.printStackTrace();
            Assert.fail();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return this;
    }

//    public int getCartItem() {
//        List<WebElement> cartItem = this._driver.findElements(lstCartItem);
//        return cartItem.get;
//    }

    // page validation
    public boolean isCartEmpty() {
        List<WebElement> cartItem = this._driver.findElements(lstCartItem);
        boolean isTrue = true;
        if (cartItem.size() > 0) {
            isTrue = false;
        }
        return isTrue;
    }

}
