package pages.components;

import pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private By iconCart = By.xpath("//a[@class= 'shopping_cart_link']");
    private WebDriver _driver;

    public Header(WebDriver driver) {
        this._driver = driver;
    }

    public CartPage navigationToCart() {
        this._driver.findElement(iconCart).click();
        return new CartPage(this._driver);
    }

}
