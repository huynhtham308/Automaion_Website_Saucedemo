package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage selectProduct(String nameProduct) throws Exception {
        this.get_actionkeyword().click(By.xpath(String.format("//*[text() = '%s']", nameProduct)));
        return new ProductDetailPage(this._driver);
    }
}
