package step;

import core.configuration.Configuration;
import core.driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class MyStepDefs  {
    private WebDriver _driver;
    private Configuration _configuration;
    @Before
    public void setUp() {
        _configuration = new Configuration("app.properties");
        _driver = new DriverFactory().getDriver(_configuration.getProperty("browser"));
        _driver.get(_configuration.getProperty("url"));
    }
    LoginPage loginPage = PageFactory.initElements(this._driver,
            LoginPage.class);
    @After
    public void teardown() {
        _driver.quit();
    }
    @Given("^I login with ([^\"]*) & ([^\"]*)$")
    public void iLoginWithUserNamePassword(String userName, String passWord) throws Exception {
        LoginPage loginPage = new LoginPage(this._driver);
        loginPage.login(userName, passWord);
    }


    @When("^I add product with name([^\"]*) to card and navigation to card$")
    public void iAddProductWithNameProductNameToCardAndNavigationToCard(String nameProduct) throws Exception {
        HomePage homePage = new HomePage(this._driver);
        homePage.selectProduct(nameProduct).addProductToCart(nameProduct).get_header().navigationToCart();
    }

    @And("^I complete checkout flow with ([^\"]*) ([^\"]*) ([^\"]*)$")
    public void iCompleteCheckoutFlow(String lastName, String firstName, String postalCode) throws Exception {
        CartPage cartPage = new CartPage(this._driver);
        cartPage.StartCheckOut().insertInformation(lastName, firstName, postalCode).finishCheckout();

    }

    @Then("I verify the order success message display")
    public void iVerifyTheOrderSuccessMessageDisplay() throws Exception {
        CheckoutCompletePage completePage = new CheckoutCompletePage(this._driver);
        completePage.isCheckout("Thank you for your order!");

    }

    @And("^I remove product with name ([^\"]*)$")
    public void iRemoveProduct(String productName) {
        CartPage cartPage = new CartPage(this._driver).removeItemByName(productName);

    }

    @Then("I verify the product is removed")
    public void iVerifyTheProductIsRemoved() {
        CartPage cartPage = new CartPage(this._driver);
        cartPage.isCartEmpty();

    }


}
