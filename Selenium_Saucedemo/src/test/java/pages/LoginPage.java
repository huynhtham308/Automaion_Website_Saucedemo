package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    //element page
    private By txtUserName = By.xpath("//input[@id='user-name']");
    private By txtPassWord = By.xpath("//input[@id='password']");
    private By btnLogin = By.xpath("//input[@id='login-button']");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public HomePage login(String userName, String passWord) throws Exception {
        this.get_actionkeyword().sendKey(txtUserName,userName);
        this.get_actionkeyword().sendKey(txtPassWord,passWord);
        this.get_actionkeyword().click(btnLogin);
        return new HomePage(this._driver);
    }
    //action page

    //validation page
}
