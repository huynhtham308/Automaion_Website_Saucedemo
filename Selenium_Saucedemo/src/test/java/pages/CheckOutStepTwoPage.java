package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckOutStepTwoPage extends BasePage {
    private By btnFinish = By.xpath("//button[@name='finish']");

    public CheckOutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage finishCheckout() {
        try {
            this.get_actionkeyword().click(btnFinish);
        } catch (NoSuchElementException e) {

            throw new NoSuchElementException("not find element");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return new CheckoutCompletePage(this._driver);
    }
}
