package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutStepOnePage extends BasePage {
    private By txtFirstName = By.xpath("//*[@id='first-name']");
    private By txtLastName = By.xpath("//*[@id='last-name']");
    private By txtPostalCode = By.xpath("//*[@id='postal-code']");
    private By btnContinute = By.xpath("//*[contains(@class, 'submit-button')]");


    public CheckOutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public CheckOutStepTwoPage insertInformation(String firstname, String lastName, String postalCode) throws Exception {
        this.get_actionkeyword().sendKey(txtFirstName,firstname);
        this.get_actionkeyword().sendKey(txtLastName,lastName);
        this.get_actionkeyword().sendKey(txtPostalCode,postalCode);
        this.get_actionkeyword().click(btnContinute);
        return new CheckOutStepTwoPage(this._driver);
    }
}
