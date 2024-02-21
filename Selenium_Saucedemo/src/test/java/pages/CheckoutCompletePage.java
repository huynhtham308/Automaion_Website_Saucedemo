package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutCompletePage extends BasePage {
    private By lblComplete = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isCheckout(String value) throws Exception {


        try {
            String pageComplete = this.get_actionkeyword().findElement(lblComplete).getText();
            if (pageComplete.contains(value)) {
                return true;
            }

        } catch (Exception e) {
            throw new Exception("no find webElement");
        }

        return false;
    }
}
