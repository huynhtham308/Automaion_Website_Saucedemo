package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage addProductToCart(String nameProduct) throws Exception {
        try {

                this.get_actionkeyword().click(By.xpath(String.format("//*[text()='%s']//..//..//button", nameProduct)));


        } catch (Exception e) {

            throw new Exception("no find element");
        }

        return this;
    }

}
